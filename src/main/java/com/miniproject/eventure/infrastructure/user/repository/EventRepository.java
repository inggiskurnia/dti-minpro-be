package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
