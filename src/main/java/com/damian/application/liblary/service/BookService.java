package com.damian.application.liblary.service;

import com.damian.application.liblary.DTOs.BookDTO.CreateBookDTO;
import com.damian.application.liblary.DTOs.BookDTO.CreateBookResponseDTO;
import com.damian.application.liblary.DTOs.BookDTO.GetBookDTO;
import com.damian.application.liblary.infrastucture.entity.BookEntity;
import com.damian.application.liblary.infrastucture.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository= bookRepository;
    }
    public List<GetBookDTO> getAll(){
        var books =bookRepository.findAll();
        return books.stream().map((book)->new GetBookDTO(book.getBook_id(),book.getIsbn(),book.getTitle(), book.getAuthor(), book.getPublisher(),book.getPublication_year(),book.getAvailable_copies()>0)).collect(Collectors.toList());
    }

    public GetBookDTO getOne(long book_id){
        var book= bookRepository.findById(book_id).orElseThrow(()-> new RuntimeException("Book not found"));
        return new GetBookDTO(book.getBook_id(),book.getIsbn(),book.getTitle(), book.getAuthor(), book.getPublisher(),book.getPublication_year(),book.getAvailable_copies()>0);
    }

    public CreateBookResponseDTO create(CreateBookDTO book){
        var bookEntity= new BookEntity();
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setAvailable_copies(book.getAvailableCopies());
        bookEntity.setPublication_year(book.getYearPublished());
        var newBook= bookRepository.save(bookEntity);

        return new CreateBookResponseDTO(newBook.getBook_id(), newBook.getIsbn(), newBook.getTitle(), newBook.getAuthor(), newBook.getPublisher(), newBook.getPublication_year(), newBook.getAvailable_copies());
    }

    public void delete(long book_id){
        if (!bookRepository.existsById(book_id)){
            throw new RuntimeException();
        }
        bookRepository.deleteById(book_id);
    }
}
