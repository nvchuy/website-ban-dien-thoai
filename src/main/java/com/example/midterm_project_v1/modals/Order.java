package com.example.midterm_project_v1.modals;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "order_name")
    private String order_name;

    @Column(name = "created_at", nullable = false)
    private String create_at;

    public Order(String order_name, String create_at) {
        this.order_name = order_name;
        this.create_at = create_at;
    }

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
