package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.user.UserPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface UserPointsRepository extends JpaRepository<UserPoints, Long> {
    List<UserPoints> findByUser_UserIdAndExpiredAtAfter(Long userId, OffsetDateTime currentTime);

    @Query("SELECT SUM(up.points - up.usedPoints) FROM UserPoints up " + "WHERE up.user.id = :userId AND up.expiredAt > :now")
    Double findTotalCurrentBalance(@Param("userId") Long userId, @Param("now") OffsetDateTime now);

}
