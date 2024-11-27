package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Long> {
}
