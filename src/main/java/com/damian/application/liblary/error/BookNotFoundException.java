package com.damian.application.liblary.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookNotFoundException extends RuntimeException {

    private BookNotFoundException(String message) {

        super(message);
    }

    public static ResponseStatusException create(String bookId) {
        BookNotFoundException exception = new BookNotFoundException(String.format("Book with id: %s is was not found", bookId));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}
