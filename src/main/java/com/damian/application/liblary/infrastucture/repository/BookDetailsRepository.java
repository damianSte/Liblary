package com.damian.application.liblary.infrastucture.repository;

import com.damian.application.liblary.infrastucture.entity.BookDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetailsEntity, Long> {
}
