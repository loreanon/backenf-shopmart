package com.avanthi.eshop.rest.api.service;

import com.avanthi.eshop.rest.api.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Long categoryId,Product newProduct);
    List<Product> getAllProduct();
    List<Product> getProductByCategoryId(Long categoryId);
    Product getProductById(Long categoryId,Long productId);
    Product addProduct(Product product);
    Product updateProduct(Long categoryId,Long productId,Product product);
    void deleteProduct(Long categoryId, Long productId);
    List<Product> searchProduct(String name);

    Object getAllProducts();
}
