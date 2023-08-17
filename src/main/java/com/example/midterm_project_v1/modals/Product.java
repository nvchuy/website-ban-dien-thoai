package com.example.midterm_project_v1.modals;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", nullable = false)
    private Integer id;
    @Column(name = "p_name", nullable = false)
    private String name;
    @Column(name = "p_image", nullable = false)
    private String image;
    @Column(name = "p_price", nullable = false, length = 50)
    private Double price;
    @Column(name = "p_color", nullable = false, length = 11)
    private String color;
    @Column(name = "p_quantity", nullable = false)
    private Integer quantity;
    @Column(name = "p_capacity", nullable = false)
    private Integer capacity;
    @Column(name = "brand_id", nullable = false, length = 11)
    private Integer brandId;
    @Column(name = "brand_name", nullable = false)
    private String brandName;
    @Column(name = "category_id", nullable = false, length = 11)
    private Integer categoryId;
    @Column(name = "category_name", nullable = false)
    private String categoryName;
    @Column(name = "user_id", nullable = false)
    private Integer userId;
}
