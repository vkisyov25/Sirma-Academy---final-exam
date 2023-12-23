package com.sirma.academy.finalProject.Repositories;

import com.sirma.academy.finalProject.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public List<Employee> findAll();

    //public void save();
    /*public void deleteAllByID();
    public Employee findByID();*/

}