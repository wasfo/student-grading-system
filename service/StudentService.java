package com.example.StudentGradingSystem.service;

import com.example.StudentGradingSystem.data.StudentDao;
import com.example.StudentGradingSystem.models.StudentInfo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StudentService {
    StudentDao studentDao = new StudentDao();

    public StudentInfo getStudentInfo(int student_id) throws SQLException {
        return studentDao.getStudentInfo(student_id);
    }
}