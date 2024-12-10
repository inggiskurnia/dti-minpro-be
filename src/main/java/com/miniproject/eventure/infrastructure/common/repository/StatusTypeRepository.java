package com.miniproject.eventure.infrastructure.common.repository;

import com.miniproject.eventure.entity.common.StatusTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTypeRepository extends JpaRepository<StatusTypes, Long> {
}
