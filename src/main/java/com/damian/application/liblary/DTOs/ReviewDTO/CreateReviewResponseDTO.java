package com.damian.application.liblary.DTOs.ReviewDTO;

import com.damian.application.liblary.infrastucture.entity.BookEntity;
import com.damian.application.liblary.infrastucture.entity.UserEntity;

import java.text.DateFormat;

public class CreateReviewResponseDTO {

    private long reviewId;
    public BookEntity bookId;
    public UserEntity userId;
    private int rating;
    private String commment;
    private DateFormat reviewDate;


    public CreateReviewResponseDTO(long reviewId, BookEntity bookId, UserEntity userId, int rating, String commment, DateFormat reviewDate) {
        this.reviewId = reviewId;
        this.bookId = bookId;
        this.userId = userId;
        this.rating = rating;
        this.commment = commment;
        this.reviewDate = reviewDate;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public BookEntity getBookId() {
        return bookId;
    }

    public void setBookId(BookEntity bookId) {
        this.bookId = bookId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCommment() {
        return commment;
    }

    public void setCommment(String commment) {
        this.commment = commment;
    }

    public DateFormat getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(DateFormat reviewDate) {
        this.reviewDate = reviewDate;
    }
}
