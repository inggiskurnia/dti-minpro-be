package com.miniproject.eventure.infrastructure.user.repository;

import com.miniproject.eventure.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
