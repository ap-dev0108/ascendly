package com.example.worklens.repository;

import com.example.worklens.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
