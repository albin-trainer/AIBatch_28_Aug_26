package com.example.springjpaproject.service;

import java.util.List;

import com.example.springjpaproject.model.Review;

public interface ReviewService {
    Review addReview(Review r, int prodId);
    List<Review> getProductReview(int pid);
}
