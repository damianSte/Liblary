package com.damian.application.liblary.DTOs.ReviewDTO;

import com.damian.application.liblary.infrastucture.entity.BookEntity;
import com.damian.application.liblary.infrastucture.entity.UserEntity;

import java.text.DateFormat;

public class CreateReviewDTO {
    public BookEntity bookId;
    public UserEntity userId;
    private int rating;
    private String comment;
    private DateFormat reviewDate;

    public CreateReviewDTO(BookEntity bookId, UserEntity userId, int rating, String comment, DateFormat reviewDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DateFormat getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(DateFormat reviewDate) {
        this.reviewDate = reviewDate;
    }
}
