package com.example.midterm_project_v1.services;

import com.example.midterm_project_v1.repository.BrandRepository;

public interface BrandService extends BrandRepository {
    public Long countById(Integer id);

}
