package com.example.springjpaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
@Id @GeneratedValue
    private int reviewId;
    private String reviewerName;

    private Float rating;
    private String review;
    @ManyToOne //mandatory . it creates FK
    @JoinColumn(name="pid")//optional 
    @JsonIgnore 
    private Product product;
    public Review(){}
   
    
    public Review(int reviewId, String reviewerName, Float rating, String review, Product product) {
        this.reviewId = reviewId;
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.review = review;
        this.product = product;
    }
    
    public String getReviewerName() {
        return reviewerName;
    }
    public int getReviewId() {
        return reviewId;
    }


    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
    public Float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }


}
