package com.miniproject.eventure.infrastructure.geography.repository;

import com.miniproject.eventure.entity.geography.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
