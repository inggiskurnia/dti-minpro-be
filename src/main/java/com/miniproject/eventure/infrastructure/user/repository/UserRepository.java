package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByReferralCode(String referralCode);
    boolean existsByReferralCode(String referralCode);
    boolean existsByEmail(String email);
}
