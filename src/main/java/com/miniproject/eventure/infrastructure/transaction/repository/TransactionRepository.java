package com.miniproject.eventure.infrastructure.transaction.repository;

import com.miniproject.eventure.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByInvoiceNumber(String invoiceNumber);

    @Query("SELECT t.invoiceNumber FROM Transaction t WHERE t.invoiceNumber LIKE :prefix% ORDER BY t.invoiceNumber DESC")
    Optional<String> findTopByInvoiceNumberStartingWithOrderByInvoiceNumberDesc(@Param("prefix") String prefix);
}
