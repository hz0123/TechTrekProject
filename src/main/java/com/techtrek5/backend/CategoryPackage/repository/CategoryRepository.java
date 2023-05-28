package com.techtrek5.backend.CategoryPackage.repository;

import com.techtrek5.backend.CategoryPackage.dao.ICategoryDao;
import com.techtrek5.backend.CategoryPackage.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends ICategoryDao, JpaRepository<CategoryModel, Long> {
    Optional<CategoryModel> findByid(long id);
    Optional<List<CategoryModel>> findByname(String name);
    @Query(value = "select * from category", nativeQuery = true)
    Optional<List<CategoryModel>> findAllCategory();
    CategoryModel save (CategoryModel categoryModel);
}
