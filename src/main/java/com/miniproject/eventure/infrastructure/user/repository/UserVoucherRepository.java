package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.user.UserVoucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserVoucherRepository extends JpaRepository<UserVoucher, Long> {
    Optional<UserVoucher> findByUserUserIdAndVoucherVoucherId(Long userId, Long voucherId);
}
