package com.sirma.academy.finalProject.Services;

import com.sirma.academy.finalProject.Models.Employee;
import com.sirma.academy.finalProject.Models.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

@Service
public class PairService {
    public static List<Pair> findPairs(List<Employee> employees) {
        List<Pair> pairs = new LinkedList<>();
        for (int i = 0; i < employees.size(); i++) {
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(i).getEmpID() != employees.get(j).getEmpID()) {
                    if (employees.get(i).getProjectID() == employees.get(j).getProjectID()) {
                        int projectId = employees.get(i).getProjectID();
                        int empId1 = employees.get(i).getEmpID();
                        int empId2 = employees.get(j).getEmpID();
                        long commonDays = calculateCommonDays(i, j, employees);
                        if(commonDays!=0){
                            Pair pair = new Pair(projectId, empId1, empId2, commonDays);
                            pairs.add(pair);
                        }
                    }

                }

            }

        }
        return pairs;
    }

    public static long calculateCommonDays(int i, int j, List<Employee> employees) {

        LocalDate startDate;
        LocalDate endDate;
        long commonDays = 0;

        if (employees.get(i).getDateFrom().isBefore(employees.get(j).getDateFrom())) {
            startDate = employees.get(j).getDateFrom();
        } else {
            startDate = employees.get(i).getDateFrom();
        }

        if (employees.get(i).getDateTo().isBefore(employees.get(j).getDateTo())) {
            endDate = employees.get(i).getDateTo();
        } else {
            endDate = employees.get(j).getDateTo();
        }

        //TODO: try - catch
        if (startDate.isBefore(endDate)) {
            commonDays = ChronoUnit.DAYS.between(startDate, endDate);
        }

        return commonDays;
    }}
