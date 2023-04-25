package com.example.StudentGradingSystem.models;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Grade {
    private int grade_id;
    private double course_id;
    private double student_id;
    private double final_grade;
}
