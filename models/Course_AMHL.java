package com.example.StudentGradingSystem.models;


import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor

public class Course_AMHL{

    private double course_id;
    private double avg;
    private double median;
    private double highest;
    private double lowest;

}
