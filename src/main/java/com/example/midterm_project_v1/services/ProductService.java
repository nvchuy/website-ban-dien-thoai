package com.example.midterm_project_v1.services;

import com.example.midterm_project_v1.modals.Product;
import com.example.midterm_project_v1.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService extends ProductRepository {
    @Query("select p from Product p where p.brandName like ?1")
    List<Product> findProductsByBrandName(String brand_name);
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByOrderByPriceAsc();
    @Query("select p from Product p where p.categoryName like %:prodSpecific% or p.name like %:prodSpecific%")
    List<Product> findProductsByProdSpecific(String prodSpecific);
}
