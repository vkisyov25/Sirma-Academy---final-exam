package com.sirma.academy.finalProject.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long ID;
    @NonNull
    private int empID;
    @NonNull
    private int projectID;
    @NonNull
    private LocalDate dateFrom;
    @NonNull
    private LocalDate dateTo;

    public Employee(int empID, int projectID, LocalDate dateFrom, LocalDate dateTo) {
        this.empID = empID;
        this.projectID = projectID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }


    public Employee() {

    }

}