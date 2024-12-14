package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.user.UserVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserVoucherRepository extends JpaRepository<UserVoucher, Long> {
    Optional<UserVoucher> findByUserUserIdAndVoucherVoucherId(Long userId, Long voucherId);
    Optional<List<UserVoucher>> findByUserUserId(Long userID);
}
