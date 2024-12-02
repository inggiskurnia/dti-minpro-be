package com.miniproject.eventure.infrastructure.user.controller;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserRequestDTO;
import com.miniproject.eventure.infrastructure.user.dto.UpdateUserRequestDTO;
import com.miniproject.eventure.usecase.user.CreateUserUseCase;
import com.miniproject.eventure.usecase.user.GetUserUseCase;
import com.miniproject.eventure.usecase.user.UpdateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    CreateUserUseCase createUserUseCase;

    @Autowired
    GetUserUseCase getUserUseCase;

    @Autowired
    UpdateUserUseCase updateUserUseCase;

    @GetMapping
    public ResponseEntity<?> getUser(){
        return ApiResponse.success(HttpStatus.OK.value(), "Get all user success", getUserUseCase.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable final Long id){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "User found !", getUserUseCase.getUserById(id));
        }catch (DataNotFoundException e){
            return ApiResponse.failed((HttpStatus.NOT_FOUND.value()), e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Create user success", createUserUseCase.createUser(req));
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody UpdateUserRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Update user success !", updateUserUseCase.updateUser(id, req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed((HttpStatus.NOT_FOUND.value()), e.getMessage());
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }
}
