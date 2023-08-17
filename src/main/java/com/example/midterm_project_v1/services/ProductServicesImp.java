package com.example.midterm_project_v1.services;

import com.example.midterm_project_v1.modals.Product;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImp {
    final
    ProductService productService;

    public ProductServicesImp(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> findAll() {
        return (List<Product>) productService.findAll();
    }

    public void save(Product product) {
        productService.save(product);
    }

    public Product get(Integer id) {
        Optional<Product> result = productService.findById(Long.valueOf(id));

        return result.orElseGet(Product::new);
    }

    public List<Product> findAllProdByBrandName(String brand_name) {
        return productService.findProductsByBrandName(brand_name);
    }

    public List<Product> sortDescPrice() {
        return productService.findAllByOrderByPriceDesc();
    }

    public List<Product> sortAscPrice() {
        return productService.findAllByOrderByPriceAsc();
    }

    public List<Product> searchProductSpecific(String specific) {
        return productService.findProductsByProdSpecific(specific);
    }
}
