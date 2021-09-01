package com.example.charity.controllers;

import com.example.charity.model.Category;
import com.example.charity.model.PersonPass;
import com.example.charity.repos.CategoryRepo;
import com.example.charity.model.Person;
import com.example.charity.repos.PersonRepo;
import com.example.charity.services.PersonService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/people")
    public List<Person> getPeople(){
        return personService.getAllPersons();
    }
    @PostMapping("/addOne")
    public Person addNewOne(@RequestBody PersonPass person) {
        Category category= categoryRepo.findById(person.getCategoryId()).orElseThrow(
                () -> new IllegalStateException("category not found")
        );

         personService.addNewPerson(person);
        return   personRepo.findTopByOrderByPersonIdDesc();
    }

    @PutMapping()
    public String deletePerson(@Param("id") Long id){
      return   personService.deletePerson(id);

    }
    @GetMapping("count_people_per_category/{id}")
    public Integer countPersonPerCategory(@PathVariable("id") Long id){
        return personService.countPeoplePerCategory(id);
    }

    @GetMapping("count_not_deleted_people_per_category/{id}")
    public Integer countNotDeletedPersonPerCategory(@PathVariable("id") Long id){
        return personService.countNotDeletedPeoplePerCategory(id);
    }

}
