package com.miniproject.eventure.infrastructure.geography.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.usecase.geography.GetProvinceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/geo/province")
public class ProvinceController {

    @Autowired
    private GetProvinceUseCase getProvinceUseCase;

    @GetMapping
    public ResponseEntity<?> getProvinces(@RequestParam(required = false) String name) {
        if (name == null) {
            return ApiResponse.success(HttpStatus.OK.value(), "Get all province success", getProvinceUseCase.getAllProvince());
        } else {
            return ApiResponse.success(HttpStatus.OK.value(), "Get province success", getProvinceUseCase.getProvince(name));
        }
    }
}
