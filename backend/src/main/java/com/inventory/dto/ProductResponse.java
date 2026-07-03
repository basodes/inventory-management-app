package com.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private Long productId;

    private String productName;

    private String description;

    private String category;

    private Double price;

    private Integer quantity;
}
