package com.miniproject.eventure.usecase.user;

import com.miniproject.eventure.infrastructure.user.dto.RedeemPointsRequestDTO;

public interface RedeemPointsUseCase {
    void redeemPoints(RedeemPointsRequestDTO req);
}
