package com.miniproject.eventure.usecase.auth;

import com.miniproject.eventure.infrastructure.auth.dto.LoginRequestDTO;
import com.miniproject.eventure.infrastructure.auth.dto.TokenPairResponseDTO;

public interface LoginUsecase {
    TokenPairResponseDTO authenticateUser(LoginRequestDTO req);
}
