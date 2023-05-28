package com.techtrek5.backend.CategoryPackage.controller;

import com.techtrek5.backend.CategoryPackage.model.CategoryModel;
import com.techtrek5.backend.CategoryPackage.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/categorycontroller")
public class CategoryController {
    private CategoryService categoryService;
    private CategoryModel categoryModel;

    @PostMapping(path = "/save")
    public CategoryModel save(@RequestBody CategoryModel categoryModel){//test for controller response
        return categoryService.save(categoryModel);
    }

    @PostMapping(path = "/findid/{id}")
    public Optional<CategoryModel> findId(@PathVariable("id") long id){//test for controller response
        return categoryService.findByid(id);
    }

    @PostMapping(path = "/findByprojectId/{name}")
    public Optional<List<CategoryModel>> findByprojectId(String name){
        return categoryService.findByname(name);
    }

    @GetMapping(path = "/findall")
    public Optional<List<CategoryModel>> findall(){
        return categoryService.findAllCategory();
    }

}
