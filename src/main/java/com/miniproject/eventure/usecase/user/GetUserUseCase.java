package com.miniproject.eventure.usecase.user;

import com.miniproject.eventure.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface GetUserUseCase {
    List<User> getAllUser();
    Optional<User> getUserById(Long id);
    Optional<User> getReferralCode(String referralCode);
}
