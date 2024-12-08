package com.miniproject.eventure.infrastructure.transaction.repository;

import com.miniproject.eventure.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
