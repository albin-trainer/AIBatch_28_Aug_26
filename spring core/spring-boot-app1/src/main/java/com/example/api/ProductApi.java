package com.example.api;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Product;
import com.example.service.ProductService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/products")
public class ProductApi {
     private ProductService service;
     public ProductApi( ProductService service){
        this.service=service;
     }
    @GetMapping("/test")
    public String test(){
         return "Hello";
    } 
    //   /products/search?maxprice=10000&minprice=500

    @GetMapping("/search")
    public List<Product> search(@RequestParam(required = false)int maxPrice, 
        @RequestParam(required = false) int minPrice,@RequestParam(required = false) String pname){
      
            return null;
    }
    @PostMapping(produces = {"application/json","applicaiton/xml"},
     consumes = {"application/json","application/xml"} )
      public ResponseEntity<Product> addNewProduct( @RequestBody @Valid  Product p){
          List<Product> products=service.getAllProducts();
          products.add(p);
        return new ResponseEntity<Product>(p, HttpStatus.CREATED);
      }

    @GetMapping("/{pid}")
    public ResponseEntity<Product> findByProductId(@PathVariable int pid){
        List<Product> products=service.getAllProducts();
        Optional<Product> optionalProduct= 
        products.stream().filter(p->p.getProdId()==pid).findFirst();

        if(optionalProduct.isPresent())
            return  new ResponseEntity<>( optionalProduct.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping( value="/sample",
    produces = { "application/xml"})
    public Product getProduct() {
        return new Product(1, "Sample Product", "19.99", null);
    }

}
