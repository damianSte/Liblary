package com.damian.application.liblary.infrastucture.repository;

import com.damian.application.liblary.infrastucture.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

    Optional<AuthEntity> findByUsername(String username);
}
