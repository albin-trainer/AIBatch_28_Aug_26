package com.example.springjpaproject.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpaproject.model.Review;
import com.example.springjpaproject.service.ReviewService;

@RestController
@RequestMapping("/api/products/{prodId}/reviews")
public class ReviewApi {

    private final ReviewService reviewService;

    public ReviewApi(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@PathVariable("prodId") int prodId, @RequestBody Review r) {
        Review saved = reviewService.addReview(r, prodId);
        if (saved == null) return ResponseEntity.notFound().build();
        return ResponseEntity.created(URI.create("/api/products/" + prodId + "/reviews/" + saved.getReviewId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(@PathVariable("prodId") int prodId) {
        return ResponseEntity.ok(reviewService.getProductReview(prodId));
    }

}
