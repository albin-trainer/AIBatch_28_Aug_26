package com.example.dto;

import java.util.List;

import com.example.springjpaproject.model.Review;

public class ProductDTO {
    private int prodId;
    private String productName;
    private int price;
    private List<Review> reviews;
    private String port;

    public ProductDTO() {}

    public ProductDTO(int prodId, String productName, int price, List<Review> reviews, String port) {
        this.prodId = prodId;
        this.productName = productName;
        this.price = price;
        this.reviews = reviews;
        this.port = port;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
