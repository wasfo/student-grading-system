package com.example.StudentGradingSystem.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentInfo {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String birthDate;
    private String gender;
    private String major;
    private String country;
}
