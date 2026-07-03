package com.inventory.service;

import com.inventory.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    Product updateProduct(Long productId, Product product);

    void deleteProduct(Long productId);
}