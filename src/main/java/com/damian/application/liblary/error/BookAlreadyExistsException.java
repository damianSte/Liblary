package com.damian.application.liblary.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookAlreadyExistsException extends RuntimeException{

    private BookAlreadyExistsException(String message){
        super(message);
    }
    public static ResponseStatusException create(String book){

        BookAlreadyExistsException exception = new BookAlreadyExistsException(String.format("Book Not created, check fields", book));

        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}
