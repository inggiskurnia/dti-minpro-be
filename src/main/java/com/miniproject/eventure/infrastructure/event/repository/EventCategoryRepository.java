package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, Long> {
    List<EventCategory> findByNameContainingIgnoreCase(String query);
}
