package com.sirma.academy.finalProject.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pair {
    private int projectId;
    private int empId1;
    private int empId2;
    private long commonDays;
}
