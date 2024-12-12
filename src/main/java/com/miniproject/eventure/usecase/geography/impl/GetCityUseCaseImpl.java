package com.miniproject.eventure.usecase.geography.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.infrastructure.geography.dto.GetCityResponseDTO;
import com.miniproject.eventure.infrastructure.geography.repository.CityRepository;
import com.miniproject.eventure.usecase.geography.GetCityUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCityUseCaseImpl implements GetCityUseCase {
    @Autowired
    CityRepository cityRepository;

    @Override
    public List<GetCityResponseDTO> searchCity(String cityName) {
        List<City> foundCities = cityRepository.findByNameContainingIgnoreCase(cityName);
        if (foundCities.isEmpty()){
            throw new DataNotFoundException("City(s) with query " + cityName + " not found !");
        }
        return foundCities.stream().map(GetCityResponseDTO::new).toList();
    }

    @Override
    public List<GetCityResponseDTO> getAllCity() {
        return cityRepository.findAll().stream().map(GetCityResponseDTO::new).toList();
    }
}
