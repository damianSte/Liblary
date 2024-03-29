package com.damian.application.liblary.DTOs.BookDTO;

public class CreateBookDTO {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int publication_year;
    private int availableCopies;


    public CreateBookDTO(String isbn, String title, String author, String publisher, int publication_year, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.availableCopies = availableCopies;
    }

    public CreateBookDTO() {
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return publication_year;
    }

    public void setYearPublished(int yearPublished) {
        this.publication_year = yearPublished;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
