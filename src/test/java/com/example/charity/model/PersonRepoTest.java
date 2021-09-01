package com.example.charity.model;

import com.example.charity.repos.CategoryRepo;
import com.example.charity.repos.PersonRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

@SpringBootTest
class PersonRepoTest {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    public  void createNewPerson(){

        Category category = Category.builder()
                .cost(665)
                .name("sam57")
                .remain(0)
                .build();
        categoryRepo.save(category);
        Category temp = categoryRepo.findById(1L).orElseThrow(
                () -> new  IllegalStateException("category not found")
        );
        Person person = Person.builder()
                .deleted(false)
                .name("v d  h")
                .date(LocalDate.now())
                .serialNumber(6559588)
                .category(temp)
                .build();
        if(categoryRepo.findById(1L).isPresent()){


        personRepo.save(person);
        System.out.println("person = " + personRepo.findById(1L));
        }

    }

    @Test
    @Transactional
    public void  addCategoryToPerson(){
        Category category = categoryRepo.findById(3L).orElseThrow(
                () -> new  IllegalStateException("category not found")
        );
            Person person=  personRepo.findById(4L).orElseThrow(
                    () -> new  IllegalStateException("user not found")
            );

//         personRepo.save(person);
        System.out.println("person = " + person);
    }
    @Test
    public void test(){
        Category c= categoryRepo.getTopByOrderByCategoryIdDesc();
        System.out.println("personList = " + c);
    }
}