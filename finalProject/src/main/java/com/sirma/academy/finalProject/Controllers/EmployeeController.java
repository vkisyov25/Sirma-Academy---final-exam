package com.sirma.academy.finalProject.Controllers;

import com.sirma.academy.finalProject.Models.Employee;
import com.sirma.academy.finalProject.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/AllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);

        if (existingEmployee.isPresent()) {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById((long) id);

        if (existingEmployee.isPresent()) {
            employee.setProjectID(id);
            employeeService.updateEmployee(employee);
            return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
    }
}
