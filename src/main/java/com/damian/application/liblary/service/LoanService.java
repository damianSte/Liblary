package com.damian.application.liblary.service;

import com.damian.application.liblary.DTOs.LoanDTO.CreateLoanDTO;
import com.damian.application.liblary.DTOs.LoanDTO.CreateLoanResponseDTO;
import com.damian.application.liblary.DTOs.LoanDTO.GetLoanDTO;
import com.damian.application.liblary.infrastucture.entity.LoanEntity;
import com.damian.application.liblary.infrastucture.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

        @Autowired
        public LoanService(LoanRepository loanRepository){this.loanRepository= loanRepository;}

        public List<GetLoanDTO> getAll(){
            var loans= loanRepository.findAll();
            return loans.stream().map((loan)-> new GetLoanDTO(loan.getLoan_id(),loan.getBook_id(),loan.getUser_id(),loan.getLoan_date(),loan.getDue_date(),loan.getReturn_date())).collect(Collectors.toList());

        }

        public GetLoanDTO getOne(long loan_id){
            var loan= loanRepository.findById(loan_id).orElseThrow(()-> new RuntimeException("Loan not found"));
            return new GetLoanDTO(loan.getLoan_id(),loan.getBook_id(),loan.getUser_id(),loan.getLoan_date(),loan.getDue_date(),loan.getReturn_date());
        }

        public CreateLoanResponseDTO create(CreateLoanDTO loan){
            var loanEntity= new LoanEntity();
            loanEntity.setBook_id(loan.getBookId());
            loanEntity.setUser_id(loan.getUserId());
            loanEntity.setLoan_date(loan.getLoanDate());
            loanEntity.setDue_date(loan.getDueDate());
            loanEntity.setReturn_date(loan.getReturnDate());

            var newLoan = loanRepository.save(loanEntity);

            return new CreateLoanResponseDTO(newLoan.getLoan_id(),newLoan.getBook_id(),newLoan.getUser_id(),newLoan.getLoan_date(),newLoan.getDue_date(),newLoan.getReturn_date());
        }

        public void delete(long loan_id){
            if(!loanRepository.existsById(loan_id)){
                throw new RuntimeException();
            }
            loanRepository.deleteById(loan_id);
        }
    }