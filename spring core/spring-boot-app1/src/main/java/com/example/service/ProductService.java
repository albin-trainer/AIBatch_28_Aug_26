package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.model.Review;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        Review review1 = new Review(1, "Alice", 4.5f);
        Review review2 = new Review(2, "Bob", 4.8f);
        Review review3 = new Review(3, "Charlie", 4.2f);

        Product product1 = new Product(101, "Laptop", "999.99", Arrays.asList(review1, review2));
        Product product2 = new Product(102, "Smartphone", "699.99", Arrays.asList(review3));
        List<Product> products= new ArrayList<>();
        products.add(product1);
        products.add(product2);
        return products;
    }
}
