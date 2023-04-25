package com.example.StudentGradingSystem.models;
import lombok.*;
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SchoolClass {

    private String instructorName;
    private String className;
    private String time;
    private int course_id;
    private String location;

}
