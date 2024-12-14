package com.miniproject.eventure.usecase.user;

import com.miniproject.eventure.entity.user.UserPoints;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserPointsRequestDTO;

public interface CreateUserPointsUseCase {
    UserPoints createUserPoints(Long userId, CreateUserPointsRequestDTO req);
}
