package com.ssafy.camping.board.controller;

import com.ssafy.camping.board.dto.Review;
import com.ssafy.camping.board.model.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("/review")
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;}


    @GetMapping("/{content_id}/{now}")
    public ResponseEntity<?> getReviewList(@PathVariable int content_id, @PathVariable int now) throws SQLException{
        List<Review> reviewList = reviewService.getAllReview(content_id, now);
        return ResponseEntity.ok().body(reviewList);
    }

    @PostMapping
    public ResponseEntity<?> registReview(@RequestBody Review review) throws SQLException{
        reviewService.addReview(review);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteReview(@PathVariable int idx) throws SQLException{
        reviewService.deleteByIdx(idx);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/content/{content_id}")
    public ResponseEntity<?> deleteAll(@PathVariable int content_id) throws SQLException{
        reviewService.deleteByContent(content_id);
        return ResponseEntity.ok().build();
    }
}
