package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventFeedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventFeedbackRepository extends JpaRepository<EventFeedback, Long> {
    Optional<EventFeedback> findByEventEventIdAndUserUserId(Long eventId, Long userId);
    Page<EventFeedback> findByEventEventId(Long eventId, Pageable pageable);
}
