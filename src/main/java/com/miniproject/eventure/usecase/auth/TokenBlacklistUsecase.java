package com.miniproject.eventure.usecase.auth;

public interface TokenBlacklistUsecase{
    void blacklistToken(String token, String expiredAt);
    boolean isTokenBlacklisted(String token);
}
