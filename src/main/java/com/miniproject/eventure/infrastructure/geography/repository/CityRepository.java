package com.miniproject.eventure.infrastructure.geography.repository;

import com.miniproject.eventure.entity.geography.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByNameContainingIgnoreCase(String cityName);
}
