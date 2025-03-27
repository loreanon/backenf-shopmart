package com.avanthi.eshop.rest.api.controller;

import com.avanthi.eshop.rest.api.entity.Product;
import com.avanthi.eshop.rest.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        var data = productService.getAllProducts();
        return ResponseEntity.ok((List<Product>) data);
    }


    @PostMapping("/{categoryId}/products")
    public ResponseEntity<Product> createProduct(@PathVariable("categoryId") Long categoryId,
                                                 @Valid @RequestBody Product product){
        var data = productService.createProduct(categoryId, product);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable("categoryId") Long categoryId){
        var data = productService.getProductByCategoryId(categoryId);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("categoryId") Long categoryId,
                                                  @PathVariable("productId") Long productId){
        var data = productService.getProductById(categoryId,productId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("categoryId") Long categoryId,
                                                 @PathVariable("productId") Long productId,
                                                 @Valid @RequestBody Product product){
        var data = productService.updateProduct(categoryId, productId, product);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("categoryId") Long categoryId,
                                              @PathVariable("productId") Long productId){
        productService.deleteProduct(categoryId, productId);
        return ResponseEntity.noContent().build();
    }
}
