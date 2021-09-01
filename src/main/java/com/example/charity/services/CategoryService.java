package com.example.charity.services;

import com.example.charity.model.Category;
import com.example.charity.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    //create new
    
    public String createCategory(Category category) throws Exception {
        if (!categoryRepo.existsByName(category.getName())) {

            Category category1= Category.builder()
                    .remain(category.getRemain())
                    .name(category.getName())
                    .cost(category.getCost())
                    .build();
            categoryRepo.save(category1);
        return "category "+ category.getName() +" has been added";
        }
        else {
            throw  new Exception("category is already exist");
        }
    }
    //get category by id
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("no category with this id")
        );
    }
    // get all categories
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }
 }
