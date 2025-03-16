package com.example.ProductManagementSystem.repository;


import com.example.ProductManagementSystem.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Get all products that cost more than a certain price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findProductsByPriceGreaterThan(@Param("price") Double price);

    // Update the price of a product using its ID
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = :price WHERE p.id = :id")
    void updateProductPrice(@Param("id") Long id, @Param("price") Double price);

    // Delete a product by its ID
    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.id = :id")
    void deleteProductById(@Param("id") Long id);

    // Find products by name (case-insensitive)
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> findProductsByNameContainingIgnoreCase(@Param("name") String name);
}
