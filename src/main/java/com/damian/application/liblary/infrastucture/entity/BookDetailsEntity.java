package com.damian.application.liblary.infrastucture.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "books_details", schema = "liblary")
public class BookDetailsEntity {


    @Id
    @Column(name="book_id")
    private long book_id;

    @OneToOne
    @MapsId
    @JoinColumn(name="book_id")
    private BookEntity book;

    @Basic
    @Column(name="genre")
    private String genre;

    @Basic
    @Column(name="summary")
    private String summary;

    @Basic
    @Column(name= "cover_image_url")
    private String cover_image_url;

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }
}
