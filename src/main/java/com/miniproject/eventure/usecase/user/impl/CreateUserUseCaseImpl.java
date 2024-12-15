package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.utils.ReferralCodeGenerator;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.entity.user.Role;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.geography.repository.CityRepository;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserRequestDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.infrastructure.user.repository.RoleRepository;
import com.miniproject.eventure.usecase.user.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final RoleRepository roleRepository;
//    private final ReferralCodeGenerator referralCodeGenerator;
//    private final CityRepository cityRepository;
//
//    public CreateUserUseCaseImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, ReferralCodeGenerator referralCodeGenerator, CityRepository cityRepository) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.roleRepository = roleRepository;
//        this.referralCodeGenerator = referralCodeGenerator;
//        this.cityRepository = cityRepository;
//    }
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ReferralCodeGenerator referralCodeGenerator;

    @Autowired
    CityRepository cityRepository;

    @Override
    public User createUser(CreateUserRequestDTO req) {
        Optional<User> foundUser = userRepository.findByEmail(req.getEmail());
        if(foundUser.isPresent()){
            throw new DuplicateRequestDataException("Email already exist");
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

//        if (req.getReferralCode() != null && !req.getReferralCode().isEmpty()) {
//            Optional<User> referrer = userRepository.findByReferralCode(req.getReferralCode());
//            if (referrer.isEmpty()) {
//                throw new DataNotFoundException("Referrer with the given referral code not found");
//            }
//            newUser.setReferrerCode(req.getReferralCode()); // Store the referral code used
//        }

        return userRepository.save(newUser);
    }
}
