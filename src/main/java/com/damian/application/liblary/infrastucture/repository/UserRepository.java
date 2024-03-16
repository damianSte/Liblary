package com.damian.application.liblary.infrastucture.repository;

import com.damian.application.liblary.infrastucture.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {}