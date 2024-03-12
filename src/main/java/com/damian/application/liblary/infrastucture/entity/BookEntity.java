package com.damian.application.liblary.infrastucture.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="books", schema = "liblary")
public class BookEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id")
    public long book_id;

    @Basic
    @Column(name="isbn", unique = true)
    private String isbn;

    @Basic
    @Column(name= "title")
    private String title;

    @Basic
    @Column(name= "author")
    private String author;

    @Basic
    @Column(name= "publisher")
    private String publisher;

    @Basic
    @Column(name= "published_year")
    private int published_year;

    @Basic
    @Column(name= "available_copies")
    private int available_copies;

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
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

    public int getPublished_year() {
        return published_year;
    }

    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }

    public int getAvailable_copies() {
        return available_copies;
    }

    public void setAvailable_copies(int available_copies) {
        this.available_copies = available_copies;
    }
}
