package com.inventory.service.impl;

import com.inventory.entity.Product;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.repository.ProductRepository;
import com.inventory.service.ProductService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + productId));
    }

    @Override
    public Product updateProduct(Long productId, Product product) {

        Product existingProduct = getProductById(productId);

        existingProduct.setProductName(product.getProductName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long productId) {

        Product product = getProductById(productId);

        productRepository.delete(product);
    }
}
