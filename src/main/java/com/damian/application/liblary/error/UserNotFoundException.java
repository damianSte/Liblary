package com.damian.application.liblary.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends RuntimeException{

    private UserNotFoundException (String message){
        super(message);
    }

    public static ResponseStatusException create(String username){
        UserNotFoundException exception = new UserNotFoundException(String.format("User with username: %s was not found", username));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}
