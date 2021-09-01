package com.example.charity.repos;

import com.example.charity.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category findByCategoryId(Long id);
    Category findByName(String name);
    boolean existsByName(String name);
     Category getTopByOrderByCategoryIdDesc();
}
