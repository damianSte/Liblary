package com.damian.application.liblary.infrastucture.repository;

import com.damian.application.liblary.infrastucture.entity.AuthEntity;
import com.damian.application.liblary.infrastucture.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByIsbn(String isbn);
}
