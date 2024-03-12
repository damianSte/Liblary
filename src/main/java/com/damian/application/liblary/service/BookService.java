package com.damian.application.liblary.service;

import com.damian.application.liblary.infrastucture.entity.BookEntity;
import com.damian.application.liblary.infrastucture.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public List<BookEntity> getAll(){
        return bookRepository.findAll();
    }

   public BookEntity getOne (long book_id){
        return bookRepository.findById(book_id).orElseThrow(()->new RuntimeException("Book not found"));
   }

    public BookEntity create (BookEntity book){
        return bookRepository.save(book);
    }
}