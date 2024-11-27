package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
}
