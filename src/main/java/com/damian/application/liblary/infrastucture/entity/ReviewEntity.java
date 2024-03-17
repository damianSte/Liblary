package com.damian.application.liblary.infrastucture.entity;

import jakarta.persistence.*;
import java.text.DateFormat;

@Entity
@Table(name = "review", schema ="liblary")
public class ReviewEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "review_id")
    private long review_id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id",nullable = false)
    public BookEntity book_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName= "user_id", nullable = false)
    public UserEntity user_id;

    @Basic
    @Column(name="rating")
    private int rating;

    @Basic
    @Column(name="comment")
    private String comment;

    @Basic
    @Column(name="review_date")
    private DateFormat review_date;


    public long getReview_id() {
        return review_id;
    }

    public void setReview_id(long review_id) {
        this.review_id = review_id;
    }

    public BookEntity getBook_id() {
        return book_id;
    }

    public void setBook_id(BookEntity book_id) {
        this.book_id = book_id;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DateFormat getReview_date() {
        return review_date;
    }

    public void setReview_date(DateFormat review_date) {
        this.review_date = review_date;
    }
}
