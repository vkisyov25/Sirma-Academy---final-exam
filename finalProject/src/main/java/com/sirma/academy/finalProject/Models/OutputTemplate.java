package com.sirma.academy.finalProject.Models;

import lombok.Getter;

import java.util.Map;

@Getter
public class OutputTemplate {
    private int empId1;
    private int empId2;
    private long commonDays;
    private Map<Integer, Long> projectDaysMap;

    public OutputTemplate(int empId1, int empId2, long commonDays, Map<Integer, Long> projectDaysMap) {
        this.empId1 = empId1;
        this.empId2 = empId2;
        this.commonDays = commonDays;
        this.projectDaysMap = projectDaysMap;
    }

    @Override
    public String toString() {
        return empId1 + "," + empId2 + "," + commonDays + "\n" + projectDaysMap;
    }
}
