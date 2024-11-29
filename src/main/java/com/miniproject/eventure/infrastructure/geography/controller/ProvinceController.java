package com.miniproject.eventure.infrastructure.geography.controller;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.exeptions.EmptyRequestDataException;
import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.geography.dto.BulkCreateProvinceRequestDTO;
import com.miniproject.eventure.infrastructure.geography.dto.CreateProvinceRequestDTO;
import com.miniproject.eventure.usecase.geography.CreateProvinceUseCase;
import com.miniproject.eventure.usecase.geography.GetProvinceUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/geo/province")
public class ProvinceController {
    private final CreateProvinceUseCase createProvinceUseCase;
    private final GetProvinceUseCase getProvinceUseCase;

    public ProvinceController(final CreateProvinceUseCase createProvinceUseCase, final GetProvinceUseCase getProvinceUseCase){
        this.createProvinceUseCase = createProvinceUseCase;
        this.getProvinceUseCase = getProvinceUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getProvinces(@RequestParam(required = false) String name) {
        if(name == null){
            return ApiResponse.success(HttpStatus.OK.value(), "Get all province success", getProvinceUseCase.getAllProvince());
        } else {
            try{
                return ApiResponse.success(HttpStatus.OK.value(), "Get province sucess", getProvinceUseCase.getProvince(name));
            }catch (DataNotFoundException e){
                return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
            }
        }
    }

    @PostMapping
    public ResponseEntity<?> createProvince(@RequestBody CreateProvinceRequestDTO req){
        try {
            var result = createProvinceUseCase.createProvince(req);
            return ApiResponse.success(HttpStatus.OK.value(),"Create new province success", result);
        }
        catch(DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }catch (EmptyRequestDataException e){
            return ApiResponse.failed((HttpStatus.BAD_REQUEST.value()), e.getMessage());
        }
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> bulkCreateProvince(@RequestBody BulkCreateProvinceRequestDTO req){
        try {
            var result = createProvinceUseCase.bulkCreateProvince(req);
            return ApiResponse.success(HttpStatus.OK.value(), "Bulk create province success", result);
        }catch (EmptyRequestDataException e){
            return ApiResponse.failed((HttpStatus.BAD_REQUEST.value()), e.getMessage());
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }
}
