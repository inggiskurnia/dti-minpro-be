package com.miniproject.eventure.infrastructure.voucher.repository;

import com.miniproject.eventure.entity.voucher.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher,Long> {
}
