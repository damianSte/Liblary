package com.damian.application.liblary.infrastucture.repository;

import com.damian.application.liblary.infrastucture.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

    Optional<AuthEntity> findByUserName(String username);
}
