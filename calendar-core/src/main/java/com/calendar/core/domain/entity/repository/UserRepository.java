package com.calendar.core.domain.entity.repository;

import com.calendar.core.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * fileName : UserRepository
 * author :  KimSangHoon
 * date : 2022/12/16
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
