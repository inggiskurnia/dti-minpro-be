package com.miniproject.eventure.infrastructure.geography.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.geography.dto.BulkCreateProvinceRequestDTO;
import com.miniproject.eventure.infrastructure.geography.dto.CreateProvinceRequestDTO;
import com.miniproject.eventure.usecase.geography.CreateProvinceUseCase;
import com.miniproject.eventure.usecase.geography.GetProvinceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/geo/province")
public class ProvinceController {

    @Autowired
    private CreateProvinceUseCase createProvinceUseCase;

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

    @PostMapping
    public ResponseEntity<?> createProvince(@RequestBody CreateProvinceRequestDTO req) {
        var result = createProvinceUseCase.createProvince(req);
        return ApiResponse.success(HttpStatus.OK.value(), "Create new province success", result);
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> bulkCreateProvince(@RequestBody BulkCreateProvinceRequestDTO req) {
        var result = createProvinceUseCase.bulkCreateProvince(req);
        return ApiResponse.success(HttpStatus.OK.value(), "Bulk create province success", result);
    }
}
