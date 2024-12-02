package com.miniproject.eventure.usecase.user;

import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserRequestDTO;

public interface CreateUserUseCase {
    User createUser(CreateUserRequestDTO req);
}
