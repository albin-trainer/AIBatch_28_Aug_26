package com.example.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
    private int prodId;
    private String productName;
    private String price;
    private List<Review> reviews;

    public Product() {
    }

    public Product(int prodId, String productName, String price, List<Review> reviews) {
        this.prodId = prodId;
        this.productName = productName;
        this.price = price;
        this.reviews = reviews;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
