package com.sirma.academy.finalProject.Services;

import com.sirma.academy.finalProject.Models.Employee;
import com.sirma.academy.finalProject.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import static com.sirma.academy.finalProject.Utils.CSVReader.readCSV;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return  employeeRepository.findById(id);
    }

    public void CsvDataToDatabase(String filePath) {
        List<Employee> employeeList = readCSV(filePath);
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = new Employee(employeeList.get(i).getEmpID(),employeeList.get(i).getProjectID(),employeeList.get(i).getDateTo(),employeeList.get(i).getDateFrom());
            boolean employeeExists = employeeRepository.findByEmpIDAndProjectIDAndDateToAndDateFrom(
                    employee.getEmpID(),
                    employee.getProjectID(),
                    employee.getDateTo(),
                    employee.getDateFrom()
            ).isPresent();

            if (!employeeExists) {
                employeeRepository.save(employee);
            }
        }


    }
}
