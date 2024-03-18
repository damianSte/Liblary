package com.damian.application.liblary.DTOs.BookDTO;

public class GetBookDTO {
    private long bookId;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private boolean isAvailable;

    public GetBookDTO(long bookId, String isbn, String title, String author, String publisher, int yearPublished, boolean isAvailable) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.isAvailable = isAvailable;
    }
}
