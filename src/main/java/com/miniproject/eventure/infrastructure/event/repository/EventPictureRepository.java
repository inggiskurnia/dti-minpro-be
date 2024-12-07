package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventPicture;
import com.miniproject.eventure.entity.event.EventReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventPictureRepository extends JpaRepository<EventPicture, Long> {
    List<EventPicture> findByEventEventId(Long eventId);
}
