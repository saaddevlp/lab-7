package com.example.ProductManagementSystem.service;


import com.example.ProductManagementSystem.DTO.ProductDTO;
import com.example.ProductManagementSystem.entities.Product;
import com.example.ProductManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products with a price greater than a given value
    public List<ProductDTO> getProductsByPriceGreaterThan(Double price) {
        List<Product> products = productRepository.findProductsByPriceGreaterThan(price);
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Update the price of a product
    public void updateProductPrice(Long id, Double price) {
        productRepository.updateProductPrice(id, price);
    }

    // Delete a product by its ID
    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

    // Search for products by name (case-insensitive)
    public List<ProductDTO> searchProductsByName(String name) {
        List<Product> products = productRepository.findProductsByNameContainingIgnoreCase(name);
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Convert Product entity to ProductDTO
    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setAvailable(product.getAvailable());
        return dto;
    }
}