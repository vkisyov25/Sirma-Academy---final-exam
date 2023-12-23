package com.sirma.academy.finalProject.Utils;

import com.sirma.academy.finalProject.Models.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Employee> readCSV(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String line = in.readLine();
            while (line != null) {
                line += ", ";
                String[] arr = line.split(", ");
                int empID = Integer.parseInt(arr[0]);
                int projectID = Integer.parseInt(arr[1]);
                LocalDate dateFrom = parseDate(arr[2]);
                LocalDate dateTo;
                if (arr[3].equals("NULL")) {
                    dateTo = parseDate(String.valueOf(LocalDate.now()));
                } else {
                    dateTo = parseDate(arr[3]);
                }
                employees.add(new Employee(empID, projectID, dateFrom, dateTo));

                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private static LocalDate parseDate(String date) {
        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy")
        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (Exception ignored) {
                // We proceed to the next format
            }
        }

        // We return null if we fail to parse
        return null;
    }
}