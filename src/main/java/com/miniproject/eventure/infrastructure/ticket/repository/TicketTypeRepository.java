package com.miniproject.eventure.infrastructure.ticket.repository;

import com.miniproject.eventure.entity.ticket.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
}
