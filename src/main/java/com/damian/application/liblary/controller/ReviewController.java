package com.damian.application.liblary.controller;


import com.damian.application.liblary.DTOs.ReviewDTO.CreateReviewDTO;
import com.damian.application.liblary.DTOs.ReviewDTO.CreateReviewResponseDTO;
import com.damian.application.liblary.DTOs.ReviewDTO.GetReviewDTO;
import com.damian.application.liblary.infrastucture.entity.ReviewEntity;
import com.damian.application.liblary.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private  ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService= reviewService;
    }

    @GetMapping
    public List<GetReviewDTO> getAllReviews(){
        return reviewService.getAll();
    }

    @GetMapping("/{review_id}")
    public GetReviewDTO getOne(@PathVariable long review_id){
        return reviewService.getOne(review_id);
    }

    @PostMapping
    public ResponseEntity<CreateReviewResponseDTO> create(@RequestBody CreateReviewDTO review){
        var newReview= reviewService.create(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    @DeleteMapping("/{review_id}")
    public ResponseEntity<Void> delete(@PathVariable long review_id){
        reviewService.delete(review_id);
        return ResponseEntity.noContent().build();
    }
}
