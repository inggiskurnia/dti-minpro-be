package com.miniproject.eventure.infrastructure.event.repository;

import com.miniproject.eventure.entity.event.EventPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPictureRepository extends JpaRepository<EventPicture, Long> {
}
