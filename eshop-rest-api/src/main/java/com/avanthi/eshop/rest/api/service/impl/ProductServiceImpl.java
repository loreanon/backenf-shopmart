package com.avanthi.eshop.rest.api.service.impl;

import com.avanthi.eshop.rest.api.entity.Category;
import com.avanthi.eshop.rest.api.entity.Product;
import com.avanthi.eshop.rest.api.exception.ResourceNotFoundException;
import com.avanthi.eshop.rest.api.repository.CategoryRepository;
import com.avanthi.eshop.rest.api.repository.ProductRepository;
import com.avanthi.eshop.rest.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Long categoryId, Product newProduct) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId",categoryId));
        // set post to comment
        newProduct.setCategory(category);
        // save comment
        return productRepository.save(newProduct);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product getProductById(Long categoryId, Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product","ProductId", + productId));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long categoryId,Long productId ,Product product) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product","ProductId", + productId));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long categoryId,Long productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product","productId",productId));
        productRepository.delete(product);

    }

    @Override
    public List<Product> searchProduct(String name) {
        return productRepository.findByNameContaining(name);
    }
}
