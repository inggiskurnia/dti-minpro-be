package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
