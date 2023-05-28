package com.techtrek5.backend.CategoryPackage.service;

import com.techtrek5.backend.CategoryPackage.dao.ICategoryDao;
import com.techtrek5.backend.CategoryPackage.model.CategoryModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService implements CategoryIService {
    private ICategoryDao iCategoryDao;
    private CategoryModel categoryModel;

    @Override
    public Optional<CategoryModel> findByid(long id) {
        return iCategoryDao.findByid(id);
    }

    @Override
    public Optional<List<CategoryModel>> findByname(String name) {
        return iCategoryDao.findByname(name);
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        return iCategoryDao.save(categoryModel);
    }

    @Override
    public Optional<List<CategoryModel>> findAllCategory() {
        return iCategoryDao.findAllCategory();
    }


}
