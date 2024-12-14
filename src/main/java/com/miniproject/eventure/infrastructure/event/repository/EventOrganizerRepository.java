package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventOrganizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventOrganizerRepository extends JpaRepository<EventOrganizer, Long> {
    Optional<EventOrganizer> findByUserUserId(Long userId);
}
