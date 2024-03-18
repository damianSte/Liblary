package com.damian.application.liblary.service;

import com.damian.application.liblary.DTOs.BookDetalsDTO.CreateBookDetailsDTO;
import com.damian.application.liblary.DTOs.BookDetalsDTO.CreateBookDetailsResponseDTO;
import com.damian.application.liblary.DTOs.BookDetalsDTO.GetBookDetailsDTO;
import com.damian.application.liblary.infrastucture.entity.BookDetailsEntity;
import com.damian.application.liblary.infrastucture.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    @Autowired
    public BookDetailsService(BookDetailsRepository bookDetailsRepository){
        this.bookDetailsRepository= bookDetailsRepository;
    }
    public List<GetBookDetailsDTO> getAll(){
        var booksDetails =bookDetailsRepository.findAll();
        return booksDetails.stream().map((bookDetails)->new GetBookDetailsDTO(bookDetails.getBook_id(),bookDetails.getBook(),bookDetails.getGenre(), bookDetails.getSummary(),bookDetails.getCover_image_url())).collect(Collectors.toList());
    }

    public GetBookDetailsDTO getOne(long book_id){
        var bookDetails= bookDetailsRepository.findById(book_id).orElseThrow(()-> new RuntimeException("Book details not found"));
        return new GetBookDetailsDTO(bookDetails.getBook_id(),bookDetails.getBook(),bookDetails.getGenre(), bookDetails.getSummary(),bookDetails.getCover_image_url());
    }

    public CreateBookDetailsResponseDTO create(CreateBookDetailsDTO bookDetails) {

        var bookDetailsEntity= new BookDetailsEntity();
        bookDetailsEntity.setBook(bookDetails.getBook());
        bookDetailsEntity.setGenre(bookDetails.getGenre());
        bookDetailsEntity.setSummary(bookDetails.getSummary());
        bookDetailsEntity.setCover_image_url(bookDetails.getCoverImageUrl());

        var newBookDetails= bookDetailsRepository.save(bookDetailsEntity);

        return new CreateBookDetailsResponseDTO(newBookDetails.getBook_id(),newBookDetails.getBook(),newBookDetails.getGenre(),newBookDetails.getSummary(),newBookDetails.getCover_image_url());

    }

    public void delete(long book_id){
        if(!bookDetailsRepository.existsById(book_id)){
            throw new RuntimeException();
        }
        bookDetailsRepository.deleteById(book_id);
    }
}
