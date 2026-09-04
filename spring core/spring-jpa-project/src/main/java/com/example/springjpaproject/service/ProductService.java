package com.example.springjpaproject.service;

import java.util.List;

import com.example.dto.ProductDTO;
import com.example.springjpaproject.model.Product;

public interface ProductService {
    Product addProduct(Product p);
    List<Product> allProducts();
    ProductDTO searchById(int pid);
    List<Product> searchByName(String pname);
    List<Product> searchByPrice(int maxPrice, int minPrice);
    Product updateProduct(Product p);
}
