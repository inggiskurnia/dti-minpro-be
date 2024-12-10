package com.miniproject.eventure.infrastructure.auth.controller;

import com.miniproject.eventure.infrastructure.auth.dto.LogoutRequestDTO;
import com.miniproject.eventure.usecase.auth.LogoutUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.auth.Claims;
import com.miniproject.eventure.infrastructure.auth.dto.LoginRequestDTO;
import com.miniproject.eventure.usecase.auth.LoginUsecase;
import com.miniproject.eventure.usecase.auth.TokenRefreshUsecase;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final LoginUsecase loginUsecase;
    private final TokenRefreshUsecase tokenRefreshUsecase;
    private final LogoutUsecase logoutUsecase;

    public AuthController(LoginUsecase loginUsecase, TokenRefreshUsecase tokenRefreshUsecase,
                          com.miniproject.eventure.usecase.auth.TokenBlacklistUsecase tokenBlacklistUsecase, LogoutUsecase logoutUsecase) {
        this.loginUsecase = loginUsecase;
        this.tokenRefreshUsecase = tokenRefreshUsecase;
        this.logoutUsecase = logoutUsecase;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody LoginRequestDTO req) {
        return ApiResponse.success("Login successful", loginUsecase.authenticateUser(req));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@Validated @RequestBody LogoutRequestDTO req) {
        var accessToken = Claims.getJwtTokenString();
        req.setAccessToken(accessToken);
        return ApiResponse.success("Logout successful", logoutUsecase.logoutUser(req));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh() {
        String tokenType = Claims.getTokenTypeFromJwt();
        if (!"REFRESH".equals(tokenType)) {
            return ApiResponse.failed(HttpStatus.UNAUTHORIZED.value(), "Invalid token type for refresh");
        }
        String token = Claims.getJwtTokenString();
        return ApiResponse.success("Refresh successful", tokenRefreshUsecase.refreshAccessToken(token));
    }
}