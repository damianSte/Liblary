package com.damian.application.liblary.infrastucture.repository;

import com.damian.application.liblary.infrastucture.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
}
