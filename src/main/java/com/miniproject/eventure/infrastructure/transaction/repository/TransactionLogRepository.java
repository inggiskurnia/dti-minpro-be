package com.miniproject.eventure.infrastructure.transaction.repository;

import com.miniproject.eventure.entity.transaction.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
}
