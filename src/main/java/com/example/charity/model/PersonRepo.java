package com.example.charity.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {
    Person findByName(String name);
    Person findTopByOrderByPersonIdDesc();
    List<Person> findPeopleByDeletedEquals(Boolean b);
    Integer countAllByCategoryCategoryId(Long id);
    Integer countAllByCategoryCategoryIdAndDeletedEquals(Long id , boolean b);
}
