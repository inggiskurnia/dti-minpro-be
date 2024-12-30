package com.miniproject.eventure.infrastructure.voucher.repository;

import com.miniproject.eventure.entity.voucher.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher,Long> {
    boolean existsByCode(String code);
    Optional<Voucher> findByName(String name);
}
