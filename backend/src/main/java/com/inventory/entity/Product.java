package com.inventory.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String productName;

    @Column(length = 500)
    private String description;

    @NotBlank(message = "Category is required")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Min(0)
    private Double price;

    @Min(0)
    private Integer quantity;
}