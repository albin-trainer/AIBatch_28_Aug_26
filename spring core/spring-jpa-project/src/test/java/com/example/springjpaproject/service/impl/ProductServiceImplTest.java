package com.example.springjpaproject.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.dto.ProductDTO;
import com.example.springjpaproject.model.Product;
import com.example.springjpaproject.model.Review;
import com.example.springjpaproject.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void addProduct_shouldSaveAndReturnProduct() {
        Product product = new Product(1, "Laptop", 25000, new ArrayList<>());
        when(productRepository.save(product)).thenReturn(product);

        Product saved = productService.addProduct(product);

        assertSame(product, saved);
        verify(productRepository).save(product);
    }

    @Test
    void allProducts_shouldReturnAllProducts() {
        List<Product> products = List.of(
                new Product(1, "Laptop", 25000, new ArrayList<>()),
                new Product(2, "Phone", 15000, new ArrayList<>())
        );
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.allProducts();

        assertEquals(products, result);
        verify(productRepository).findAll();
    }

    @Test
    void searchById_shouldMapProductToProductDto() {
        List<Review> reviews = List.of(new Review(1, "Alice", 4.5f, "Great", null));
        Product product = new Product(1, "Laptop", 25000, reviews);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        ProductDTO result = productService.searchById(1);

        assertNotNull(result);
        assertEquals(1, result.getProdId());
        assertEquals("Laptop", result.getProductName());
        assertEquals(25000, result.getPrice());
        assertEquals(reviews, result.getReviews());
        assertNull(result.getPort());
    }

    @Test
    void searchById_shouldReturnNullWhenProductDoesNotExist() {
        when(productRepository.findById(99)).thenReturn(Optional.empty());

        ProductDTO result = productService.searchById(99);

        assertNull(result);
    }

    @Test
    void searchByName_shouldReturnMatchingProducts() {
        List<Product> products = List.of(new Product(1, "Laptop", 25000, new ArrayList<>()));
        when(productRepository.findByProductNameContainingIgnoreCase("lap")).thenReturn(products);

        List<Product> result = productService.searchByName("lap");

        assertEquals(products, result);
    }

    @Test
    void searchByPrice_shouldUseMinMaxOrder() {
        List<Product> products = List.of(new Product(1, "Laptop", 25000, new ArrayList<>()));
        when(productRepository.findByPriceBetween(1000, 5000)).thenReturn(products);

        List<Product> result = productService.searchByPrice(5000, 1000);

        assertEquals(products, result);
        verify(productRepository).findByPriceBetween(1000, 5000);
    }

    @Test
    void updateProduct_shouldReturnNullWhenProductIsNull() {
        assertNull(productService.updateProduct(null));
        verify(productRepository, never()).save(any());
    }

    @Test
    void updateProduct_shouldSaveNewProductWhenIdIsZero() {
        Product product = new Product(0, "Keyboard", 1500, new ArrayList<>());
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.updateProduct(product);

        assertSame(product, result);
        verify(productRepository).save(product);
    }

    @Test
    void updateProduct_shouldUpdateExistingProduct() {
        Product existing = new Product(2, "Old Name", 1000, new ArrayList<>());
        Product update = new Product(2, "Updated Name", 2000, new ArrayList<>());
        when(productRepository.findById(2)).thenReturn(Optional.of(existing));
        when(productRepository.save(existing)).thenReturn(existing);

        Product result = productService.updateProduct(update);

        assertNotNull(result);
        assertEquals("Updated Name", result.getProductName());
        assertEquals(2000, result.getPrice());
        assertEquals(update.getReviews(), result.getReviews());
        verify(productRepository).save(existing);
    }
}
