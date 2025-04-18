package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventFeedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventFeedbackRepository extends JpaRepository<EventFeedback, Long> {
    Optional<EventFeedback> findByEventTicketEventTicketIdAndUserUserId(Long eventTicketId, Long userId);
    Page<EventFeedback> findByEventTicketEventTicketId(Long eventTicket, Pageable pageable);
}
