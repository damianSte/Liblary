package com.damian.application.liblary.infrastucture.repository;

import com.damian.application.liblary.infrastucture.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
