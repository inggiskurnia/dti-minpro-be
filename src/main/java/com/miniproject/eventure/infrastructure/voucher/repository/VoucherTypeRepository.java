package com.miniproject.eventure.infrastructure.voucher.repository;

import com.miniproject.eventure.entity.voucher.VoucherType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherTypeRepository extends JpaRepository<VoucherType, Long> {
}
