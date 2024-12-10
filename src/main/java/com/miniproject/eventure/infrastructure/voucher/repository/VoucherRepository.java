package com.miniproject.eventure.infrastructure.voucher.repository;

import com.miniproject.eventure.entity.voucher.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherRepository extends JpaRepository<Voucher,Long> {
    boolean existsByCode(String code);
    Optional<Voucher> findByCode(String code);
    Optional<Voucher> findByName(String name);
}
