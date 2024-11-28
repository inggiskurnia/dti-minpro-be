package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventReviewRepository extends JpaRepository<EventReview, Long> {
}
