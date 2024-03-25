package com.damian.application.liblary.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LoanNotFoundException extends RuntimeException{

    private LoanNotFoundException(String message){
        super(message);
    }

    public ResponseStatusException create (String loanID){
        LoanNotFoundException exception = new LoanNotFoundException(String.format("Loan with id: %s is was not found", loanID));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);

    }
}
