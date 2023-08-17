package com.example.midterm_project_v1.services;

import com.example.midterm_project_v1.modals.Order;
import com.example.midterm_project_v1.modals.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp {
    final OrderService orderService;

    public OrderServiceImp(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<Order> findAll() {
        return (List<Order>) orderService.findAll();
    }

    public Order save(Order order) {
        return orderService.save(order);
    }

    public Order get(Integer id) {
        Optional<Order> result = orderService.findById(id);

        return result.orElseGet(Order::new);
    }
}
