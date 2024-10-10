package com.fahad.bossEmployee_management.service;

import com.fahad.bossEmployee_management.model.Employee;
import com.fahad.bossEmployee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmp(Employee employee){
        employeeRepository.save(employee);
    }

    public void saveBoss(Employee employee){
        employee.setBoss(true);
        employeeRepository.save(employee);
    }

    public void updateBossSalaryOnRating(int amount, int rating) {
        employeeRepository.updateBossSalaryOnRating(amount,rating);
    }


    public List<Employee> getEmployeeBasedOnAgeAndRating(int age, int rating){
        return employeeRepository.getEmployeeByRatingAndAgeCondition(age,rating);
    }

    public List<Employee> getEmployeeOnRating(int rating){
        return employeeRepository.getEmployeeOnRating(rating);
    }

}
