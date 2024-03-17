package com.damian.application.liblary.service;

import com.damian.application.liblary.infrastucture.entity.BookDetailsEntity;
import com.damian.application.liblary.infrastucture.entity.BookEntity;
import com.damian.application.liblary.infrastucture.repository.BookDetailsRepository;
import com.damian.application.liblary.infrastucture.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    @Autowired
    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public List<BookDetailsEntity> getAll(){
        return bookDetailsRepository.findAll();
    }

    public BookDetailsEntity getOne (long book_id){
        return bookDetailsRepository.findById(book_id).orElseThrow(()->new RuntimeException("Book Details not found"));
    }

    public BookDetailsEntity create (BookDetailsEntity bookDetails){
        return bookDetailsRepository.save(bookDetails);
    }
    public void delete(long book_id){
        if (bookDetailsRepository.existsById(book_id)){
            throw new RuntimeException();
        }
        bookDetailsRepository.deleteById(book_id);
    }
}