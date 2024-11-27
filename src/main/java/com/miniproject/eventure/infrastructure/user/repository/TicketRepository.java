package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
