package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.EventPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPictureRepository extends JpaRepository<EventPicture, Long> {
}
