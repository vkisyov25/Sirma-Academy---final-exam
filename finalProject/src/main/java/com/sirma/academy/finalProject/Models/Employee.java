package com.sirma.academy.finalProject.Models;

import java.util.Date;
import java.util.Objects;

public class Employee {
    private String employeeID;
    private String projectID;
    private Date startDate;
    private Date endDate;

    public Employee(String employeeID, String projectID, Date startDate, Date endDate) {
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", projectID='" + projectID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
