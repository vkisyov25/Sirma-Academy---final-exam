![Academy's Logo](https://github.com/vkisyov25/Sirma-Academy---final-exam/blob/main/academyLogo.png)
# Sirma-Academy---final-exam
## TASK: Pair of employees who have worked together

## Packages
### 1. Utils Package
In the `Utils` package, the `CSVReader` class is responsible for reading data from the input file "Input.csv" using the `readCSV` function. The class also includes a `parseDate` function, that allows working with multiple date formats such as :  "yyyy-MM-dd," "dd/MM/yyyy," and "dd-MM-yyyy."

### 2. Models Package
The `Models` package contains the following classes:
- `Employee`: Represents an employee.
- `Pair`: Represents a pair of employees.
- `OutputTemplate`: Serves as a template for output information.

### 3. Services Package
The `Services` package holds the main logic in the `OutputTemplateService` class.
#### Functions in `OutputTemplateService`:
- `calculateCommonDays`: Calculates the common workdays for each employee pair.
- `findPairs`: Find pairs and calculates their common workdays using the `calculateCommonDays` function and save them in List<Pair> pairs.
![Изображение на листа](https://github.com/vkisyov25/Sirma-Academy---final-exam/blob/main/logo1.png)
- `commonDaysOfEachPairForEachProject`: This function return List<OutputTemplate> outputTemplateList.
The list looks like this:
![Изображение на листа](https://github.com/vkisyov25/Sirma-Academy---final-exam/blob/main/logo2.png)
That was the reason I made OutputTemplate model so I can keep in map how many common days they had in each project. This is the template of output information in the task. That’s why I named the model and the service like that – OutputTemplate.
- `maxCommonDays`: Function that finds the pair with the most days in common.
The `Services` package is also contained `EmployeeService` class in which is the logic for CRUD for Employees
### 4. Controllers Package
In the Controllers package, the OutputTemplateController serves as a controller for visualizing all pairs and the pair with the most common workdays.
Endpoints:
- @GetMapping("/allPairs"): Displays all employee pairs.
- @GetMapping("/maxCommonDays"): Displays the pair with the most common workdays.
The Controllers package also contained `EmployeeControllers` for CRUD for Employees.
Endpoints:
- @GetMapping("/AllEmployees"): Display all employees from the database.
- @PostMapping("/create"): Adding employee in the database
- @DeleteMapping("/delete/{id}"): Delete the employee with this id. First checking if it exists.
  ![Изображение](https://github.com/vkisyov25/Sirma-Academy---final-exam/blob/main/delete.png)
- @PutMapping("/update/{id}"): Update the project id of the employees with this id .First checking if employees exists.
  ![Изображение](https://github.com/vkisyov25/Sirma-Academy---final-exam/blob/main/update.png)
### 5. Repositories Package
The `Repositories` package contained `EmployeeRepository` interface that extend interface `JpaRepository`. The purpose of this is to make CRUD for Employess
