package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventOrganizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {
    Page<Event> findAll(Pageable pageable);
    List<Event> findByNameContainingIgnoreCase(String eventName);
    List<Event> findByOrganizer_EventOrganizerId(Long organizerId);
//    List<Event> findByOrganizerId(EventOrganizer organizer);
}
