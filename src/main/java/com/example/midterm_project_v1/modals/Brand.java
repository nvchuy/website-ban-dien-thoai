package com.example.midterm_project_v1.modals;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", nullable = false)
    private Integer id;

    @Column(name = "brand_name", nullable = false)
    private String brand_name;

    public Brand(Integer brand_id, String brand_name) {
        this.id = brand_id;
        this.brand_name = brand_name;
    }

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Product> products;
}
