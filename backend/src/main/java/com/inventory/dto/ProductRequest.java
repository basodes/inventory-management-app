package com.inventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    private String productName;

    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    @Min(value = 0)
    private Double price;

    @Min(value = 0)
    private Integer quantity;
}
