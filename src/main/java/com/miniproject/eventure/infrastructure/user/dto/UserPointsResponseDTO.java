package com.miniproject.eventure.infrastructure.user.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserPointsResponseDTO {
    private BigDecimal totalPoints;
    private BigDecimal totalUsedPoints;
}
