package com.fahad.bossEmployee_management.repository;

import com.fahad.bossEmployee_management.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //writing our own methods for performing database queries using our own queries

    @Query(nativeQuery = true,value="SELECT * FROM employee WHERE age< :age and rating> :rating ")
    public List<Employee> getEmployeeByRatingAndAgeCondition(int age, int rating);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="UPDATE employee set salary= :amount WHERE rating> :rating AND is_boss=true")
    public void updateBossSalaryOnRating(int amount, int rating);

    @Query(nativeQuery = true, value="SELECT * FROM employee WHERE rating> :rating")
    public List<Employee> getEmployeeOnRating(int rating);

}
