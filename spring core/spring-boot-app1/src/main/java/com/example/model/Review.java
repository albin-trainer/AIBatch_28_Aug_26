package com.example.model;

public class Review {
    private int id;
    private String reviewerName;
    private float rating;

    public Review() {
    }

    public Review(int id, String reviewerName, float rating) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
