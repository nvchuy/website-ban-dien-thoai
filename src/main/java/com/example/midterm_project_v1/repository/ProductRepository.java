package com.example.midterm_project_v1.repository;

import com.example.midterm_project_v1.modals.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
