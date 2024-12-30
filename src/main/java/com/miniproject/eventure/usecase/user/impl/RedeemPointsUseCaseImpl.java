//package com.miniproject.eventure.usecase.user.impl;
//
//import com.miniproject.eventure.entity.user.UserPoints;
//import com.miniproject.eventure.entity.user.RedeemedPoints;
//import com.miniproject.eventure.entity.transaction.Transaction;
//import com.miniproject.eventure.infrastructure.user.dto.RedeemPointsRequestDTO;
//import com.miniproject.eventure.infrastructure.user.repository.UserPointsRepository;
//import com.miniproject.eventure.infrastructure.user.repository.RedeemedPointsRepository;
//import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
//import com.miniproject.eventure.usecase.user.RedeemPointsUseCase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.time.OffsetDateTime;
//import java.util.List;
//
//@Service
//public class RedeemPointsUseCaseImpl implements RedeemPointsUseCase {
//
//    @Autowired
//    UserPointsRepository userPointsRepository;
//
//    @Autowired
//    RedeemedPointsRepository redeemedPointsRepository;
//
//    @Autowired
//    TransactionRepository transactionRepository;
//
//    @Override
//    public void redeemPoints(RedeemPointsRequestDTO redeemPointsRequestDTO) {
//        // Fetch user's points
//        List<UserPoints> userPointsList = userPointsRepository
//                .findByUser_UserIdAndExpiredAtAfter(redeemPointsRequestDTO.getUserId(), OffsetDateTime.now());
//
//        BigDecimal pointsToRedeem = redeemPointsRequestDTO.getPointsToRedeem();
//        BigDecimal redeemedAmount = BigDecimal.ZERO;
//
//        // Redeem points logic (using the soon-to-expire points first)
//        for (UserPoints userPoints : userPointsList) {
//            if (pointsToRedeem.compareTo(BigDecimal.ZERO) > 0) {
//                BigDecimal pointsAvailable = userPoints.getPoints().subtract(userPoints.getUsedPoints());
//                BigDecimal pointsToUse = pointsAvailable.min(pointsToRedeem);
//
//                userPoints.setUsedPoints(userPoints.getUsedPoints().add(pointsToUse));
//                userPointsRepository.save(userPoints);
//
//                RedeemedPoints redeemedPoints = new RedeemedPoints();
//                redeemedPoints.setUserPoints(userPoints);
//                redeemedPoints.setRedeemedAmount(pointsToUse);
//                redeemedPoints.setTransaction(new Transaction());
//                redeemedPoints.setCreatedAt(OffsetDateTime.now());
//                redeemedPointsRepository.save(redeemedPoints);
//
//                redeemedAmount = redeemedAmount.add(pointsToUse);
//                pointsToRedeem = pointsToRedeem.subtract(pointsToUse);
//            }
//        }
//
//        if (pointsToRedeem.compareTo(BigDecimal.ZERO) > 0) {
//            throw new IllegalArgumentException("Not enough points available to redeem.");
//        }
//    }
//}
