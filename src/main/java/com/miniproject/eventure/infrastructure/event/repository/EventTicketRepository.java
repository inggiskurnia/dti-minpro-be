package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.miniproject.eventure.entity.event.Event;

import java.util.List;

@Repository
public interface EventTicketRepository extends JpaRepository<EventTicket, Long> {
    List<EventTicket> findByEventEventId(Long eventId);
    List<EventTicket> findByEvent(Event event);
    EventTicket findByEventAndEventTicketId(Event event, Long eventTicketId);
}
