package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.user.UserVoucher;
import com.miniproject.eventure.infrastructure.user.dto.GetUserVoucherResponseDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserVoucherRepository;
import com.miniproject.eventure.usecase.user.GetUserVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetUserVoucherUseCaseImpl implements GetUserVoucherUseCase {

    @Autowired
    UserVoucherRepository userVoucherRepository;

    @Override
    public List<GetUserVoucherResponseDTO> getUserVoucher(Long userId) {
        List<UserVoucher> vouchers = userVoucherRepository.findByUserUserId(userId);

        if (vouchers.isEmpty()){
            throw new DataNotFoundException("Voucher not found");
        }

        LocalDateTime now = LocalDateTime.now();

        return vouchers.stream()
                .filter(voucher -> voucher.getExpiredAt().isAfter(OffsetDateTime.now()))
                .map(GetUserVoucherResponseDTO::new)
                .collect(Collectors.toList());
    }
}
