package com.techtrek5.zihengBackend.CategoryPackage.dao;

import com.techtrek5.zihengBackend.CategoryPackage.model.CategoryModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ICategoryDao {
    Optional<CategoryModel> findByid(long id);
    Optional<List<CategoryModel>> findByname(String name);
    CategoryModel save(CategoryModel categoryModel);
    Optional<List<CategoryModel>> findAllCategory();
}
