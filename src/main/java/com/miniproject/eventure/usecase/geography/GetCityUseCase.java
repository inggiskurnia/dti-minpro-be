package com.miniproject.eventure.usecase.geography;

import com.miniproject.eventure.infrastructure.geography.dto.GetCityResponseDTO;

import java.util.List;

public interface GetCityUseCase {
    List<GetCityResponseDTO> searchCity(String cityName);
    List<GetCityResponseDTO> getAllCity();
}
