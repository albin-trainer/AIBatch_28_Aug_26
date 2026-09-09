package com.example.springjpaproject.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.springjpaproject.model.Product;
import com.example.springjpaproject.model.Review;
import com.example.springjpaproject.repository.ProductRepository;
import com.example.springjpaproject.repository.ReviewRepository;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Test
    void addReview_shouldAssociateProductAndSaveReview() {
        Product product = new Product(10, "Laptop", 25000, null);
        Review review = new Review(0, "Alice", 4.5f, "Nice laptop", null);
        when(productRepository.findById(10)).thenReturn(Optional.of(product));
        when(reviewRepository.save(review)).thenReturn(review);

        Review saved = reviewService.addReview(review, 10);

        assertNotNull(saved);
        assertEquals(product, saved.getProduct());
        verify(reviewRepository).save(review);
    }

    @Test
    void addReview_shouldReturnNullWhenProductDoesNotExist() {
        Review review = new Review(0, "Alice", 4.5f, "Nice laptop", null);
        when(productRepository.findById(99)).thenReturn(Optional.empty());

        Review result = reviewService.addReview(review, 99);

        assertNull(result);
        verify(reviewRepository, never()).save(any());
    }

    @Test
    void getProductReview_shouldReturnReviewsForProduct() {
        List<Review> reviews = List.of(
                new Review(1, "Alice", 4.5f, "Good", null),
                new Review(2, "Bob", 4.8f, "Excellent", null)
        );
        when(reviewRepository.findByProductProdId(10)).thenReturn(reviews);

        List<Review> result = reviewService.getProductReview(10);

        assertEquals(reviews, result);
        verify(reviewRepository).findByProductProdId(10);
    }
}
