package com.miniproject.eventure.infrastructure.geography.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.geography.dto.CreateProvinceRequestDTO;
import com.miniproject.eventure.usecase.geography.CreateProvinceUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/geo/province")
public class ProvinceController {
    private final CreateProvinceUseCase createProvinceUseCase;

    public ProvinceController(final CreateProvinceUseCase createProvinceUseCase){
        this.createProvinceUseCase = createProvinceUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createProvince(@RequestBody CreateProvinceRequestDTO req){
        var result = createProvinceUseCase.createProvince(req);
        return ApiResponse.success("Create new province success", result);
    }
}
