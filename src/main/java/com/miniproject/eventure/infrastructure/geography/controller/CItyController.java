package com.miniproject.eventure.infrastructure.geography.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.usecase.geography.GetCityUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/geo/city")
public class CItyController {

    @Autowired
    GetCityUseCase getCityUseCase;

    @GetMapping
    public ResponseEntity<?> searchCities(@RequestParam String query){
        if(!query.isEmpty()){
            return ApiResponse.success(HttpStatus.OK.value(), "City(s) found !", getCityUseCase.searchCity(query));
        }else {
            return ApiResponse.success(HttpStatus.OK.value(), "Cities found !", getCityUseCase.getAllCity());
        }
    }
}
