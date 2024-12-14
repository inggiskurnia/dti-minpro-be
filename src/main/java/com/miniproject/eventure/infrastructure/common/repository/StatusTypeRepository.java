package com.miniproject.eventure.infrastructure.common.repository;

import com.miniproject.eventure.entity.common.StatusTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTypeRepository extends JpaRepository<StatusTypes, Long> {
}
