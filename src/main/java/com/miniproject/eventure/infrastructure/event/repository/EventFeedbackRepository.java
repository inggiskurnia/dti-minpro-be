package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventFeedbackRepository extends JpaRepository<EventFeedback, Long> {
}
