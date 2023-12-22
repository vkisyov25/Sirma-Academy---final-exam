package com.sirma.academy.finalProject.Models;

public class Pair {
    private int projectId;
    private int empId1;
    private int empId2;
    private long commonDays;

    public Pair(int projectId, int empId1, int empId2, long commonDays) {
        this.projectId = projectId;
        this.empId1 = empId1;
        this.empId2 = empId2;
        this.commonDays = commonDays;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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
}
