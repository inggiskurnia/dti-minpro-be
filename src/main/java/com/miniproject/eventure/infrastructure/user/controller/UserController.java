package com.miniproject.eventure.infrastructure.user.controller;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserRequestDTO;
import com.miniproject.eventure.usecase.user.CreateUserUseCase;
import com.miniproject.eventure.usecase.user.GetUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase){
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getUser(){
        return ApiResponse.success(HttpStatus.OK.value(), "Get all user success", getUserUseCase.getAllUser());
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Create user success", createUserUseCase.createUser(req));
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }
}
