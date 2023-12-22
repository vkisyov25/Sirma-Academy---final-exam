package com.sirma.academy.finalProject.Services;

import com.sirma.academy.finalProject.Models.Employee;
import com.sirma.academy.finalProject.Models.OutputTemplate;
import com.sirma.academy.finalProject.Models.Pair;
import com.sirma.academy.finalProject.Utils.CSVReader;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class OutputTemplateService {
    public  List<OutputTemplate> commonDaysOfEachPair() {
        List<Pair> pairs = PairService.findPairs(CSVReader.readCSV("D:\\JavaPrograms\\Sirma-Academy---final-exam\\finalProject\\src\\main\\resources\\input.cvs"));
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
                map.put(pairs.get(i).getProjectId(), pairs.get(i).getCommonDays());
                long commonDays = pairs.get(i).getCommonDays();
                OutputTemplate outputTemplate = new OutputTemplate(empId1, empId2, commonDays, map);
                outputTemplateList.add(outputTemplate);
                pairs.remove(i);
            } else {
                pairs.remove(i);
                i--;
                isSave = false;
            }

            if (pairs.size() == 1) {
                int empId1 = pairs.get(0).getEmpId1();
                int empId2 = pairs.get(0).getEmpId2();
                map.put(pairs.get(i).getProjectId(), pairs.get(0).getCommonDays());
                OutputTemplate outputTemplate = new OutputTemplate(empId1, empId2, pairs.get(0).getCommonDays(), map);
                outputTemplateList.add(outputTemplate);
                pairs.remove(i);
            }

            map = new HashMap<>();
        }
        return outputTemplateList;
    }
}
