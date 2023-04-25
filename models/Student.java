package com.example.StudentGradingSystem.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Account studentAccount;
    private int id;
    private StudentInfo studentInfo;
    private HashMap<Course, Grade> course_grade_map = new HashMap<>();
    private List<Course> courseList = new ArrayList<>();
    private List<SchoolClass> schoolClasses = new ArrayList<>();
}
