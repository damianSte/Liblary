package com.damian.application.liblary.infrastucture.repository;

import com.damian.application.liblary.infrastucture.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
