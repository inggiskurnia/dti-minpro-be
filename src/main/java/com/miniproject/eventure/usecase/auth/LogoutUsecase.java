package com.miniproject.eventure.usecase.auth;

import com.miniproject.eventure.infrastructure.auth.dto.LogoutRequestDTO;

public interface LogoutUsecase {
    Boolean logoutUser(LogoutRequestDTO req);
}
