package com.example.charity.controllers;

import com.example.charity.model.Category;
import com.example.charity.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> categories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/addOne")
    public String addNewCategory(@RequestBody Category category) throws Exception  {
        return categoryService.createCategory(category);
    }
}

