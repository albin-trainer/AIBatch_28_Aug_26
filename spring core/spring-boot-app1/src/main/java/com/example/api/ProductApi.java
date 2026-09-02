package com.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductApi {
    @GetMapping("/test")
    public String test(){
         return "Hello";
    }
    @GetMapping( value="/sample",
    produces = { "application/xml","application/json"})
    public Product getProduct() {
        return new Product(1, "Sample Product", "19.99", null);
    }
}
