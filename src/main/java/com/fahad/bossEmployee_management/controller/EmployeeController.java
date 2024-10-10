package com.fahad.bossEmployee_management.controller;

import com.fahad.bossEmployee_management.model.Employee;
import com.fahad.bossEmployee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Create a employee-boss management system where you can perform important CRUD operations upon them.
// POST :ADD employee,addboss
// Get employees who are under a given age and have rating greater than x.
//PUT : update all the boss salary of the boses, by x whose rating is > y.
// GET:Find out all count of the employees, who’s bossRating and employee rating > x
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public void saveEmp(@RequestBody Employee employee){
        employeeService.saveEmp(employee);
    }

    @PostMapping("/addBoss")
    public void saveBoss(@RequestBody Employee employee){
        employeeService.saveBoss(employee);
    }


    // Get employees who are under a given age and have rating greater than x.
    @GetMapping("/getOnAgeAndRatingCondition/{age}/{rating}")
    public List<Employee> getEmployeeOnAgeAndRating(@PathVariable int age, @PathVariable int rating){
        return employeeService.getEmployeeBasedOnAgeAndRating(age,rating);
    }

    //PUT : update all the boss salary of the boses, by x whose rating is > y.
    @PutMapping("/update/{amount}/{rating}")
    public void updateBossSalaryOnRating(@PathVariable  int amount, @PathVariable int rating){
        employeeService.updateBossSalaryOnRating(amount,rating);
    }


    @GetMapping("/findByRating/{rating}")
    public List<Employee> getEmployeeOnRating(@PathVariable int rating){
        return employeeService.getEmployeeOnRating(rating);
    }
}
