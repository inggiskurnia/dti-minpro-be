package com.miniproject.eventure.usecase.auth.impl;

import com.miniproject.eventure.infrastructure.auth.dto.TokenPairResponseDTO;
import com.miniproject.eventure.usecase.auth.TokenGenerationUsecase;
import com.miniproject.eventure.usecase.auth.TokenRefreshUsecase;
import org.springframework.stereotype.Service;

@Service
public class TokenRefreshUsecaseImpl implements TokenRefreshUsecase {
    private final TokenGenerationUsecase tokenService;

    public TokenRefreshUsecaseImpl(TokenGenerationUsecase tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public TokenPairResponseDTO refreshAccessToken(String refreshToken) {
        String newAccessToken = tokenService.refreshAccessToken(refreshToken);
        return new TokenPairResponseDTO(newAccessToken, refreshToken, "Bearer");
    }
}
