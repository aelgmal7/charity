package com.example.charity.services;

import com.example.charity.controllers.PersonPass;
import com.example.charity.model.CategoryRepo;
import com.example.charity.model.Person;
import com.example.charity.model.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    // get all
    public List<Person> getAllPersons(){

        return personRepo.findPeopleByDeletedEquals(false);
    }
    // add new
    public Person addNewPerson(PersonPass person){
        Person person1 = Person.builder()
                .name(person.getName())
                .date(person.getDate())
                .serialNumber(person.getSerialNumber())
                .deleted(person.isDeleted())
                .category(categoryRepo.findByCategoryId(person.getCategoryId()))
                .build();
        personRepo.save(person1);
        return personRepo.findTopByOrderByPersonIdDesc();
    }
    //update
    @Transactional
    public String deletePerson(Long id){
        Person person = personRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("person not found")
        );
        person.setDeleted(true);
       // personRepo.save(person);
        return "deleted successfully";

    }
    public Integer countPeoplePerCategory(Long id){
       return personRepo.countAllByCategoryCategoryId(id);
    }
    public Integer countNotDeletedPeoplePerCategory(Long id){
        return personRepo.countAllByCategoryCategoryIdAndDeletedEquals(id, false);
    }
}
