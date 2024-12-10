package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventFeedback;
import com.miniproject.eventure.entity.event.EventReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventReviewRepository extends JpaRepository<EventReview, Long> {
    Optional<EventReview> findByEventEventIdAndUserUserId(Long eventId, Long userId);
    Page<EventReview> findByEventEventId(Long eventId, Pageable pageable);
}
