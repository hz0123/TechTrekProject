package com.techtrek5.backend.CategoryPackage.service;

import com.techtrek5.backend.CategoryPackage.model.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface CategoryIService {
    Optional<CategoryModel> findByid(long id);
    Optional<List<CategoryModel>> findByname(String name);
    CategoryModel save (CategoryModel categoryModel);
    Optional<List<CategoryModel>> findAllCategory();
}
