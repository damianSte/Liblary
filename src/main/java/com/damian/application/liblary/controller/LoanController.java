package com.damian.application.liblary.controller;

import com.damian.application.liblary.DTOs.LoanDTO.CreateLoanDTO;
import com.damian.application.liblary.DTOs.LoanDTO.CreateLoanResponseDTO;
import com.damian.application.liblary.DTOs.LoanDTO.GetLoanDTO;
import com.damian.application.liblary.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/loan")
public class LoanController {

    private final LoanService loanService;
    @Autowired
    public LoanController (LoanService loanService){this.loanService= loanService;}

    @GetMapping
    public List<GetLoanDTO> getAllLoans(){return loanService.getAll();}

    @GetMapping("/{loan_id}")
    public GetLoanDTO getOne(@PathVariable long loan_id){
        return loanService.getOne(loan_id);
    }

    @PostMapping
    public ResponseEntity<CreateLoanResponseDTO> create(@RequestBody CreateLoanDTO loan){
        var newLoan= loanService.create(loan);
        return new ResponseEntity<>(newLoan, HttpStatus.CREATED);
    }

    @DeleteMapping("/{loan_id}")
    public ResponseEntity<Void> delete(@PathVariable long loan_id){
        loanService.delete(loan_id);
        return ResponseEntity.noContent().build();
    }
}
