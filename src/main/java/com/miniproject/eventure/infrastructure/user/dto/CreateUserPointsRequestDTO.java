package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.entity.user.UserPoints;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data

public class CreateUserPointsRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Double totalAmount;

    private Long transactionId;

    private String validityPeriod;

    public UserPoints toEntity(){
        UserPoints userPoints = new UserPoints();
        userPoints.setTotalAmount(this.totalAmount);
        return userPoints;
    }
}
