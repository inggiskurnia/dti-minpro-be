package com.miniproject.eventure.usecase.user;

import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.user.dto.UpdateUserRequestDTO;

public interface UpdateUserUseCase {
    User updateUser(Long id, UpdateUserRequestDTO req);
}
