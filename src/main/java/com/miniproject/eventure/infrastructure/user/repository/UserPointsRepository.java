package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.user.UserPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserPointsRepository extends JpaRepository<UserPoints, Long> {

    @Query("SELECT SUM(up.points - up.usedPoints) FROM UserPoints up " + "WHERE up.user.id = :userId AND up.expiredAt > :now")
    Double findTotalCurrentBalance(@Param("userId") Long userId, @Param("now") OffsetDateTime now);

    Optional<UserPoints> findByUserUserId(Long userId);
    List<UserPoints> findByUserUserIdAndExpiredAtAfterOrderByExpiredAtAsc(Long userId, OffsetDateTime expiredAt);

}
