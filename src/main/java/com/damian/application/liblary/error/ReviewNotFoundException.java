package com.damian.application.liblary.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReviewNotFoundException extends RuntimeException{

    private ReviewNotFoundException(String message){
        super(message);
    }
    public static ResponseStatusException create(String review){

        ReviewNotFoundException exception = new ReviewNotFoundException(String.format("Loan with id: %s is was not found", review));

        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}
