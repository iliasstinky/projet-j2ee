package com.example.controller.spring.mvc.test.doa.repositories;

import com.example.controller.spring.mvc.test.doa.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo  extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByusername(String username);
}