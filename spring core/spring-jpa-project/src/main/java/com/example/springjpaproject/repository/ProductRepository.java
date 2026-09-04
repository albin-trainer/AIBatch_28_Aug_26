package com.example.springjpaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.springjpaproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByProductNameContainingIgnoreCase(String name);
	List<Product> findByPriceBetween(int min, int max);
}
