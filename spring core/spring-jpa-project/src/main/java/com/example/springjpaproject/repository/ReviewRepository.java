package com.example.springjpaproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springjpaproject.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductProdId(int prodId);
}
