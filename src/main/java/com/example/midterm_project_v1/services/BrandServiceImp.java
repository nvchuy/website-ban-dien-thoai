package com.example.midterm_project_v1.services;

import com.example.midterm_project_v1.modals.Brand;
import com.example.midterm_project_v1.modals.Product;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImp {
    final BrandService brandService;

    public BrandServiceImp(BrandService brandService) {
        this.brandService = brandService;
    }

    public List<Brand> findAll() {
        return (List<Brand>) brandService.findAll();
    }
    public void save(Brand brand) {
        brandService.save(brand);
    }
}
