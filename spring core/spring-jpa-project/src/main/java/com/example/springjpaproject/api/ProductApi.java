package com.example.springjpaproject.api;

import java.net.URI;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDTO;
import com.example.springjpaproject.model.Product;
import com.example.springjpaproject.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

    private final ProductService productService;
    private final Environment env;

    public ProductApi(ProductService productService, Environment env) {
        this.productService = productService;
        this.env = env;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product p) {
        Product saved = productService.addProduct(p);
        return ResponseEntity.created(URI.create("/api/products/" + saved.getProdId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Product>> allProducts() {
        return ResponseEntity.ok(productService.allProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable("id") int id) {
        ProductDTO dto = productService.searchById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        String port = env.getProperty("local.server.port");
        dto.setPort(port);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByName(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "min", required = false) Integer min,
            @RequestParam(value = "max", required = false) Integer max) {
        if (name != null) {
            return ResponseEntity.ok(productService.searchByName(name));
        }
        if (min != null && max != null) {
            return ResponseEntity.ok(productService.searchByPrice(max, min));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product p) {
        p.setProdId(id);
        Product updated = productService.updateProduct(p);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

}
