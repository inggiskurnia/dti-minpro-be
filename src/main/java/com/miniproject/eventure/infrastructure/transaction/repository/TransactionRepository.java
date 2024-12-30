package com.miniproject.eventure.infrastructure.transaction.repository;

import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByInvoiceNumber(String invoiceNumber);
    boolean existsByInvoiceNumber(String invoiceNumber);
    List<Transaction> findByUserUserId(Long userId);

    @Query("SELECT t.invoiceNumber FROM Transaction t WHERE t.invoiceNumber LIKE :prefix% ORDER BY t.invoiceNumber DESC")
    Optional<String> findTopByInvoiceNumberStartingWithOrderByInvoiceNumberDesc(@Param("prefix") String prefix);

    @Query("SELECT SUM(t.totalAmount) FROM Transaction t WHERE t.eventTicket.event.eventId = :eventId")
    BigDecimal sumTransactionAmountByEventId(Long eventId);

    // Fetch transactions for a specific event ticket
    List<Transaction> findByEventTicket(EventTicket eventTicket);

    @Query("SELECT t FROM Transaction t WHERE t.eventTicket.event.eventId = :eventId AND t.createdAt BETWEEN :startDate AND :endDate")
    List<Transaction> findTransactionsByEventIdAndDateRange(
            @Param("eventId") Long eventId,
            @Param("startDate") OffsetDateTime startDate,
            @Param("endDate") OffsetDateTime endDate
    );

    @Query("SELECT COUNT(t) FROM Transaction t WHERE t.eventTicket.event.eventId = :eventId")
    Long countByEventId(@Param("eventId") Long eventId);
}