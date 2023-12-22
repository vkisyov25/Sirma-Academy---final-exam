package com.sirma.academy.finalProject.Models;

import java.util.Map;

public class OutputTemplate {
    private  int empId1;
    private  int empId2;
    private long commonDays;
    private Map<Integer, Long> projectDaysMap;

    public OutputTemplate(int empId1, int empId2, long commonDays, Map<Integer, Long> projectDaysMap) {
        this.empId1 = empId1;
        this.empId2 = empId2;
        this.commonDays = commonDays;
        this.projectDaysMap = projectDaysMap;
    }

    public int getEmpId1() {
        return empId1;
    }

    public void setEmpId1(int empId1) {
        this.empId1 = empId1;
    }

    public int getEmpId2() {
        return empId2;
    }

    public void setEmpId2(int empId2) {
        this.empId2 = empId2;
    }

    public long getCommonDays() {
        return commonDays;
    }

    public void setCommonDays(long commonDays) {
        this.commonDays = commonDays;
    }

    public Map<Integer, Long> getProjectDaysMap() {
        return projectDaysMap;
    }

    public void setProjectDaysMap(Map<Integer, Long> projectDaysMap) {
        this.projectDaysMap = projectDaysMap;
    }
}
