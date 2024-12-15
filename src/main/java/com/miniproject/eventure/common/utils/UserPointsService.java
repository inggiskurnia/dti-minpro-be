package com.miniproject.eventure.common.utils;

import com.miniproject.eventure.entity.user.UserPoints;
import com.miniproject.eventure.infrastructure.user.dto.UserPointsResponseDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class UserPointsService {

    @Autowired
    private UserPointsRepository userPointsRepository;

    public UserPointsResponseDTO deductUserPoints(Long userId, BigDecimal pointsToDeduct) {
        List<UserPoints> userPointsList = userPointsRepository.findByUserUserIdAndExpiredAtAfterOrderByExpiredAtAsc(userId, OffsetDateTime.now());

        BigDecimal remainingPointsToDeduct = pointsToDeduct;

        for (UserPoints userPoints : userPointsList) {
            if (remainingPointsToDeduct.compareTo(BigDecimal.ZERO) <= 0) {
                break;
            }

            BigDecimal availablePoints = userPoints.getPoints().subtract(userPoints.getUsedPoints());
            if (availablePoints.compareTo(remainingPointsToDeduct) >= 0) {
                userPoints.setUsedPoints(userPoints.getUsedPoints().add(remainingPointsToDeduct));
                remainingPointsToDeduct = BigDecimal.ZERO;
            } else {
                userPoints.setUsedPoints(userPoints.getUsedPoints().add(availablePoints));
                remainingPointsToDeduct = remainingPointsToDeduct.subtract(availablePoints);
            }

            userPointsRepository.save(userPoints);
        }

        if (remainingPointsToDeduct.compareTo(BigDecimal.ZERO) > 0) {
            throw new RuntimeException("Insufficient points");
        }

        // Calculate total points and total used points
        BigDecimal totalPoints = BigDecimal.ZERO;
        BigDecimal totalUsedPoints = BigDecimal.ZERO;

        for (UserPoints userPoints : userPointsList) {
            totalPoints = totalPoints.add(userPoints.getPoints());
            totalUsedPoints = totalUsedPoints.add(userPoints.getUsedPoints());
        }

        UserPointsResponseDTO responseDTO = new UserPointsResponseDTO();
        responseDTO.setTotalPoints(totalPoints);
        responseDTO.setTotalUsedPoints(totalUsedPoints);

        return responseDTO;
    }
}
