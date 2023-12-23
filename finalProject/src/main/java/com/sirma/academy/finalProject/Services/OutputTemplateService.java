package com.sirma.academy.finalProject.Services;

import com.sirma.academy.finalProject.Models.Employee;
import com.sirma.academy.finalProject.Models.OutputTemplate;
import com.sirma.academy.finalProject.Models.Pair;
import com.sirma.academy.finalProject.Utils.CSVReader;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class OutputTemplateService {
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
                        if (commonDays != 0) {
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

        if (startDate.isBefore(endDate)) {
            commonDays = ChronoUnit.DAYS.between(startDate, endDate);
        }

        return commonDays;
    }

    public List<OutputTemplate> commonDaysOfEachPairForEachProject() {
        List<Pair> pairs = findPairs(CSVReader.readCSV("D:\\JavaPrograms\\Sirma-Academy---final-exam\\finalProject\\src\\main\\resources\\input.cvs"));
        List<OutputTemplate> outputTemplateList = new LinkedList<>();
        Map<Integer, Long> map = new HashMap<>();
        boolean isSave = false;
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = i + 1; j < pairs.size(); j++) {
                long allDays;
                // (1,2) = (2,1)
                if (((pairs.get(i).getEmpId1() == pairs.get(j).getEmpId1()) && (pairs.get(i).getEmpId2() == pairs.get(j).getEmpId2())) || (pairs.get(i).getEmpId1() == pairs.get(j).getEmpId2()) && (pairs.get(i).getEmpId2() == pairs.get(j).getEmpId1())) {
                    allDays = pairs.get(i).getCommonDays();
                    map.put(pairs.get(i).getProjectId(), pairs.get(i).getCommonDays());
                    int empId1 = pairs.get(i).getEmpId1();
                    int empId2 = pairs.get(i).getEmpId2();
                    allDays += pairs.get(j).getCommonDays();
                    map.put(pairs.get(j).getProjectId(), pairs.get(j).getCommonDays());
                    OutputTemplate outputTemplate = new OutputTemplate(empId1, empId2, allDays, map);
                    outputTemplateList.add(outputTemplate);
                    isSave = true;
                    pairs.remove(j);
                    j -= 2;
                }
            }

            if (!isSave) {
                int empId1 = pairs.get(i).getEmpId1();
                int empId2 = pairs.get(i).getEmpId2();
                long commonDays = pairs.get(i).getCommonDays();
                map.put(pairs.get(i).getProjectId(), commonDays);
                OutputTemplate outputTemplate = new OutputTemplate(empId1, empId2, commonDays, map);
                outputTemplateList.add(outputTemplate);
                pairs.remove(i);
            } else {
                pairs.remove(i);
                i--;
                isSave = false;
            }
            map = new HashMap<>();//to reset creating a new HashMap

            if (pairs.size() == 1) {
                int empId1 = pairs.get(0).getEmpId1();
                int empId2 = pairs.get(0).getEmpId2();
                map.put(pairs.get(i).getProjectId(), pairs.get(0).getCommonDays());
                OutputTemplate outputTemplate = new OutputTemplate(empId1, empId2, pairs.get(0).getCommonDays(), map);
                outputTemplateList.add(outputTemplate);
                pairs.remove(i);
            }

        }
        return outputTemplateList;
    }

    public OutputTemplate maxCommonDays() {
        OutputTemplate outputTemplate;
        List<OutputTemplate> outputTemplateList = commonDaysOfEachPairForEachProject();
        long maxCommonDays = 0;
        int maxCommonDaysIndex = 0;
        for (int i = 0; i < outputTemplateList.size(); i++) {
            if (outputTemplateList.get(i).getCommonDays() > maxCommonDays) {
                maxCommonDays = outputTemplateList.get(i).getCommonDays();
                maxCommonDaysIndex = i;
            }
        }
        return outputTemplate = new OutputTemplate(outputTemplateList.get(maxCommonDaysIndex).getEmpId1(),
                outputTemplateList.get(maxCommonDaysIndex).getEmpId2(), maxCommonDays, outputTemplateList.get(maxCommonDaysIndex).getProjectDaysMap());
    }
}
