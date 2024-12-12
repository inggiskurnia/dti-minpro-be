package com.miniproject.eventure.infrastructure.geography.dto;

import com.miniproject.eventure.entity.geography.City;
import lombok.Data;

@Data
public class GetCityResponseDTO {
    private Long cityId;
    private String cityName;

    public GetCityResponseDTO(City city){
        this.cityId = city.getCityId();
        this.cityName = city.getName();
    }
}
