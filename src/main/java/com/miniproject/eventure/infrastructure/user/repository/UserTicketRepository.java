package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.user.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTicketRepository extends JpaRepository<UserTicket, Long> {
    List<UserTicket> findByUserUserId(Long userId);
}
