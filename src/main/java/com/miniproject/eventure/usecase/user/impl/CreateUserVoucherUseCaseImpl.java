package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.exeptions.UserNotFoundException;
import com.miniproject.eventure.common.exeptions.VoucherNotFoundException;
import com.miniproject.eventure.common.utils.ExpiryDate;
import com.miniproject.eventure.common.utils.VoucherService;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.entity.user.UserVoucher;
import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserVoucherRequestDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserVoucherRepository;
import com.miniproject.eventure.infrastructure.voucher.repository.VoucherRepository;
import com.miniproject.eventure.usecase.user.CreateUserVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class CreateUserVoucherUseCaseImpl implements CreateUserVoucherUseCase {
    @Autowired
    UserRepository userRepository;

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    UserVoucherRepository userVoucherRepository;

    @Autowired
    ExpiryDate expiryDate;

    @Override
    public UserVoucher createUserVoucher(CreateUserVoucherRequestDTO req) {
        Optional<UserVoucher> userVoucher = userVoucherRepository.findByUserUserIdAndVoucherVoucherId(req.getUserId(), req.getVoucherId());
        if (userVoucher.isPresent()){
            throw new DuplicateRequestDataException("Voucher already claimed by user");
        }

        User user = userRepository.findById(req.getUserId())
                .orElseThrow(()-> new UserNotFoundException(req.getUserId()));

        Voucher voucher = voucherRepository.findById(req.getVoucherId())
                .orElseThrow(VoucherNotFoundException::new);

        OffsetDateTime expiryAt = expiryDate.calculateExpiryDate(voucher.getValidityPeriod());

        return userVoucherRepository.save(req.toEntity(user, voucher, expiryAt));
    }
}
