package com.miniproject.eventure.infrastructure.geography.repository;

import com.miniproject.eventure.entity.geography.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Optional<Province> findByName(String name);
    List<Province> findByNameIn(List<String> names);
}
