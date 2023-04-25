package com.example.StudentGradingSystem.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentCourse {


    private Course course;
    private String grade;

}
