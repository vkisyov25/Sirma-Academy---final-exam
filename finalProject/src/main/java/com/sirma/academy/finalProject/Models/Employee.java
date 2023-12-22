package com.sirma.academy.finalProject.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Employee {
    private int empID;
    private int projectID;
    private LocalDate dateFrom;
    private LocalDate dateTo;

}