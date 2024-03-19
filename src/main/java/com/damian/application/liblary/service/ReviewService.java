package com.damian.application.liblary.service;
import com.damian.application.liblary.DTOs.ReviewDTO.CreateReviewDTO;
import com.damian.application.liblary.DTOs.ReviewDTO.CreateReviewResponseDTO;
import com.damian.application.liblary.DTOs.ReviewDTO.GetReviewDTO;
import com.damian.application.liblary.infrastucture.entity.ReviewEntity;
import com.damian.application.liblary.infrastucture.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<GetReviewDTO> getAll(){
        var reviews= reviewRepository.findAll();
        return reviews.stream().map((review)-> new GetReviewDTO(review.getReview_id(), review.getBook_id(),review.getUser_id(),review.getRating(),review.getComment(),review.getReview_date())).collect(Collectors.toList());
    }

    public GetReviewDTO getOne(long review_id){
        var review= reviewRepository.findById(review_id).orElseThrow(()->new RuntimeException("Review not found"));
        return new GetReviewDTO(review.getReview_id(), review.getBook_id(),review.getUser_id(),review.getRating(),review.getComment(),review.getReview_date());
    }

    public CreateReviewResponseDTO create(CreateReviewDTO review){
        var reviewEntity= new ReviewEntity();

        reviewEntity.setBook_id(review.getBookId());
        reviewEntity.setUser_id(review.getUserId());
        reviewEntity.setRating(review.getRating());
        reviewEntity.setComment(review.getComment());

        var newReview = reviewRepository.save(reviewEntity);
        return new CreateReviewResponseDTO(newReview.getReview_id(), newReview.getBook_id(), newReview.getUser_id(),newReview.getRating(),newReview.getComment(),newReview.getReview_date());
    }

    public void delete(long review_id){
        if(!reviewRepository.existsById(review_id)){
            throw new RuntimeException();
        }
        reviewRepository.deleteById(review_id);
    }

}
