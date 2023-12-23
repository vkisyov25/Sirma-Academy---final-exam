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

### 4. Controllers Package
In the Controllers package, the OutputTemplateController serves as a controller for visualizing all pairs and the pair with the most common workdays.
Endpoints:
- @GetMapping("/allPairs"): Displays all employee pairs.
- @GetMapping("/maxCommonDays"): Displays the pair with the most common workdays.
