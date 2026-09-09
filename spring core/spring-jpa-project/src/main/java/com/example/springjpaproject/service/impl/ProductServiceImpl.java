package com.example.springjpaproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dto.ProductDTO;
import com.example.springjpaproject.model.Product;
import com.example.springjpaproject.repository.ProductRepository;
import com.example.springjpaproject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product p) {
        String pname=p.getProductName();
        return productRepository.save(p);
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDTO searchById(int pid) {
        Optional<Product> opt = productRepository.findById(pid);
        if (opt.isEmpty()) return null;
        Product p = opt.get();
        ProductDTO dto = new ProductDTO();
        dto.setProdId(p.getProdId());
        dto.setProductName(p.getProductName());
        dto.setPrice(p.getPrice());
        dto.setReviews(p.getReviews());
        dto.setPort(null);
        return dto;
    }

    @Override
    public List<Product> searchByName(String pname) {
        return productRepository.findByProductNameContainingIgnoreCase(pname);
    }

    @Override
    public List<Product> searchByPrice(int maxPrice, int minPrice) {
        int min = Math.min(minPrice, maxPrice);
        int max = Math.max(minPrice, maxPrice);
        return productRepository.findByPriceBetween(min, max);
    }

    @Override
    public Product updateProduct(Product p) {
        if (p == null) return null;
        Integer id = p.getProdId();
        if (id == 0) { // no id provided
            return productRepository.save(p);
        }
        Optional<Product> existing = productRepository.findById(id);
        if (existing.isPresent()) {
            Product ex = existing.get();
            ex.setProductName(p.getProductName());
            ex.setPrice(p.getPrice());
            ex.setReviews(p.getReviews());
            return productRepository.save(ex);
        }
        return productRepository.save(p);
    }

}
