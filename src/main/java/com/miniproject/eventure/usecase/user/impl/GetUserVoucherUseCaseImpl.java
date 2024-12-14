package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.entity.user.UserVoucher;
import com.miniproject.eventure.infrastructure.user.dto.GetUserVoucherResponseDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserVoucherRepository;
import com.miniproject.eventure.usecase.user.GetUserVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetUserVoucherUseCaseImpl implements GetUserVoucherUseCase {

    @Autowired
    UserVoucherRepository userVoucherRepository;

    @Override
    public List<GetUserVoucherResponseDTO> getUserVoucher(Long userId) {
        List<UserVoucher> vouchers = userVoucherRepository.findByUserUserId(userId)
                .orElseThrow(()-> new DataNotFoundException("Voucher not found"));

        return vouchers.stream().map(GetUserVoucherResponseDTO::new).toList();
    }
}
