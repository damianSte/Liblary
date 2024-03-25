package com.damian.application.liblary.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReviewAlreadyExistsException extends RuntimeException{
    private ReviewAlreadyExistsException(String message){
        super(message);
    }
    public static ResponseStatusException create(String review){

        ReviewAlreadyExistsException exception = new ReviewAlreadyExistsException(String.format("Review already exists", review));

        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }

}
