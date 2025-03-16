package com.example.ProductManagementSystem.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Boolean available;
}
