package com.example.ProductManagementSystem.controller;


import com.example.ProductManagementSystem.DTO.ProductDTO;
import com.example.ProductManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products with a price greater than a given value
    @GetMapping("/expensive")
    public ResponseEntity<List<ProductDTO>> getExpensiveProducts(@RequestParam Double price) {
        List<ProductDTO> products = productService.getProductsByPriceGreaterThan(price);
        return ResponseEntity.ok(products);
    }

    // Update the price of a product
    @PutMapping("/{id}/price")
    public ResponseEntity<Void> updateProductPrice(@PathVariable Long id, @RequestParam Double price) {
        productService.updateProductPrice(id, price);
        return ResponseEntity.ok().build();
    }

    // Delete a product by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    // Search for products by name (case-insensitive)
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProductsByName(@RequestParam String name) {
        List<ProductDTO> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);
    }
}