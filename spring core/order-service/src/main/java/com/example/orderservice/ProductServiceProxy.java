package com.example.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "product-service")
public interface ProductServiceProxy {
    @GetMapping ("/api/products/{pid}")
    public Order getProduct(@PathVariable 
        int pid);
}
