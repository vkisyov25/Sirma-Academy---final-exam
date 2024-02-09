package com.sirma.academy.finalProject.Repositories;

import com.sirma.academy.finalProject.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Object> findByEmpIDAndProjectIDAndDateToAndDateFrom(int empID, int projectID, LocalDate dateTo, LocalDate dateFrom);

}