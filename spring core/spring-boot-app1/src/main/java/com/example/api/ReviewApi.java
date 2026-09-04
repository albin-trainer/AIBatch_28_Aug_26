package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.model.Review;
import com.example.service.ProductService;

@RestController
@RequestMapping("/api/products/{prodId}/reviews")
public class ReviewApi {
     private ProductService service;
     public ReviewApi( ProductService service){
        this.service=service;
     }
     @GetMapping
public List<Review> allreviews( @PathVariable int prodId){
    Optional<Product> optional=
 service.getAllProducts().stream().
 filter(p->p.getProdId()==prodId).findFirst();
 if(optional.isPresent()){
    return optional.get().getReviews();
 }
    return null;
}
}
