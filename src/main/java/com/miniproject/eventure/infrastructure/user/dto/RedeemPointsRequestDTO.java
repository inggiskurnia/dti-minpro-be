package com.miniproject.eventure.infrastructure.user.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RedeemPointsRequestDTO {
    private Long userId;
    private BigDecimal pointsToRedeem;
}
