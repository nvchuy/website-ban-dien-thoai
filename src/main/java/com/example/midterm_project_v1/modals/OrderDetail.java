package com.example.midterm_project_v1.modals;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id", nullable = false)
    private Integer order_detail_id;

    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "product_id", nullable = false)
    private Integer product_id;

    @Column(name = "product_name", nullable = false)
    private String product_name;

    @Column(name = "product_price", nullable = false)
    private Double product_price;

    @Column(name = "product_quantity", nullable = false)
    private Integer product_quantity;

    public OrderDetail(Integer order_id, Integer product_id, String product_name, Double product_price, Integer product_quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
    }
}
