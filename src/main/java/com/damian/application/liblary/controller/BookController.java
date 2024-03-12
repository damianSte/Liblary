package com.damian.application.liblary.controller;

import com.damian.application.liblary.infrastucture.entity.BookEntity;
import com.damian.application.liblary.infrastucture.repository.BookRepository;
import com.damian.application.liblary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<BookEntity> getAllBooks(){

        return bookService.getAll();
    }


}
