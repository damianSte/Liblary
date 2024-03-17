package com.damian.application.liblary.controller;

import com.damian.application.liblary.infrastucture.entity.BookDetailsEntity;
import com.damian.application.liblary.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookDetails")
public class BookDetailsController {

    private BookDetailsService bookDetailsService;
    @Autowired
    public BookDetailsController(BookDetailsService bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }

    @GetMapping
    public List<BookDetailsEntity> getAllBooksDetails(){
        return bookDetailsService.getAll();
    }
    @GetMapping("{book_id}")
    public BookDetailsEntity getOne(@PathVariable long book_id){
        return bookDetailsService.getOne(book_id);
    }

    @PostMapping
    public ResponseEntity<BookDetailsEntity> create(@RequestBody BookDetailsEntity bookDetails){
        var newBookDetails = bookDetailsService.create(bookDetails);
        return new ResponseEntity<>(newBookDetails, HttpStatus.CREATED);
    }
    @DeleteMapping("{book_id}")
    public ResponseEntity<Void> delete(@PathVariable long book_id){
        bookDetailsService.delete(book_id);

        return ResponseEntity.noContent().build();
    }


}