package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.utils.ReferralCodeGenerator;
import com.miniproject.eventure.entity.user.Role;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.entity.user.UserPoints;
import com.miniproject.eventure.entity.user.UserVoucher;
import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserRequestDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserPointsRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.infrastructure.user.repository.RoleRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserVoucherRepository;
import com.miniproject.eventure.infrastructure.voucher.repository.VoucherRepository;
import com.miniproject.eventure.usecase.user.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ReferralCodeGenerator referralCodeGenerator;

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    UserVoucherRepository userVoucherRepository;

    @Autowired
    UserPointsRepository userPointsRepository;

    @Override
    public User createUser(CreateUserRequestDTO req) {
        Optional<User> foundUser = userRepository.findByEmail(req.getEmail());
        if (foundUser.isPresent()) {
            throw new DuplicateRequestDataException("Email already exists");
        }

        // Create user entity
        User newUser = req.toEntity();
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        Optional<Role> defaultRole = roleRepository.findByName("USER");
        if (defaultRole.isPresent()) {
            newUser.getRoles().add(defaultRole.get());
        } else {
            throw new RuntimeException("Default role not found");
        }

        // Generate referral code
        String referralCode = referralCodeGenerator.generateReferralCode(
                newUser.getFullName(), newUser.getBirthdate()
        );
        newUser.setReferralCode(referralCode);

        // Save user entity first to persist the user
        newUser = userRepository.save(newUser);

        // Using other user referral code
        if (req.getReferrerCode() != null && !req.getReferrerCode().isEmpty()) {
            Optional<User> referrer = userRepository.findByReferralCode(req.getReferrerCode());
            if (referrer.isPresent()) {
                // Apply referral voucher to the user
                Voucher referralVoucher = voucherRepository.findByName("Referral Voucher")
                        .orElseThrow(() -> new DataNotFoundException("Referral voucher not found"));

                UserVoucher userVoucher = new UserVoucher();
                userVoucher.setUser(newUser);
                userVoucher.setVoucher(referralVoucher);
                userVoucher.setExpiredAt(OffsetDateTime.now().plusDays(90));

                userVoucherRepository.save(userVoucher);

                // Add points to the referrer
                User referrerUser = referrer.get();
                UserPoints points = new UserPoints();
                points.setUser(referrerUser);
                points.setPoints(BigDecimal.valueOf(10000));
                points.setUsedPoints(BigDecimal.ZERO);
                points.setExpiredAt(OffsetDateTime.now().plusDays(90));
                userPointsRepository.save(points);
            } else {
                throw new DataNotFoundException("Referrer not found");
            }
            newUser.setReferrerCode(req.getReferrerCode()); // Store the referral code used
        }

        return newUser;
    }

}
