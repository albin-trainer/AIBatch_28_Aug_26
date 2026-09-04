package com.example.springjpaproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springjpaproject.model.Product;
import com.example.springjpaproject.model.Review;
import com.example.springjpaproject.repository.ProductRepository;
import com.example.springjpaproject.repository.ReviewRepository;
import com.example.springjpaproject.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Review addReview(Review r, int prodId) {
        Optional<Product> opt = productRepository.findById(prodId);
        if (opt.isEmpty()) return null;
        Product p = opt.get();
        r.setProduct(p);
        return reviewRepository.save(r);
    }

    @Override
    public List<Review> getProductReview(int pid) {
        return reviewRepository.findByProductProdId(pid);
    }

}
