package com.miniproject.eventure.usecase.auth;

import com.miniproject.eventure.infrastructure.auth.dto.TokenPairResponseDTO;

public interface TokenRefreshUsecase {
    TokenPairResponseDTO refreshAccessToken(String refreshToken);
}
