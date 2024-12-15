package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventOrganizerRepository extends JpaRepository<EventOrganizer, Long> {
//    Optional<EventOrganizer> findByEventOrganizerId(Long eventOrganizerId);
    Optional<EventOrganizer> findByUserUserId(Long userId);
}
