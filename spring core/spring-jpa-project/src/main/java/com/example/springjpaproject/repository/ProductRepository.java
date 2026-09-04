package com.example.springjpaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springjpaproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
