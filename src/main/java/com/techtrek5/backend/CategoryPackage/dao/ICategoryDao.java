package com.techtrek5.backend.CategoryPackage.dao;

import com.techtrek5.backend.CategoryPackage.model.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface ICategoryDao {
    Optional<CategoryModel> findByid(long id);
    Optional<List<CategoryModel>> findByname(String name);
    CategoryModel save(CategoryModel categoryModel);
    Optional<List<CategoryModel>> findAllCategory();
}
