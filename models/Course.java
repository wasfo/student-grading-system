package com.example.StudentGradingSystem.models;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Course {
    private int id;
    private String courseName;
    private Course_AMHL course_amhl;
}
