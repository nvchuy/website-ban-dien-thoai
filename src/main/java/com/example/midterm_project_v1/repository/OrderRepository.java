package com.example.midterm_project_v1.repository;

import com.example.midterm_project_v1.modals.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
