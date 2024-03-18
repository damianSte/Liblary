package com.damian.application.liblary.controller;

import com.damian.application.liblary.DTOs.BookDTO.CreateBookDTO;
import com.damian.application.liblary.DTOs.BookDTO.CreateBookResponseDTO;
import com.damian.application.liblary.DTOs.BookDTO.GetBookDTO;
import com.damian.application.liblary.infrastucture.entity.BookEntity;
import com.damian.application.liblary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<GetBookDTO> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/{book_id}")
    public GetBookDTO getOne(@PathVariable long book_id){
        return bookService.getOne(book_id);
    }

    @PostMapping
    public ResponseEntity<CreateBookResponseDTO> create(@RequestBody CreateBookDTO book){
        var newBook= bookService.create(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<Void> delete(@PathVariable long book_id){
        bookService.delete(book_id);
        return ResponseEntity.noContent().build();
    }

}
