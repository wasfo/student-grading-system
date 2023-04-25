package com.example.StudentGradingSystem.service;

import com.example.StudentGradingSystem.data.ClassDao;
import com.example.StudentGradingSystem.models.SchoolClass;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClassService {
    ClassDao classDao = new ClassDao();
    public ClassService() {
    }

    public List<SchoolClass> getStudentClasses(int student_id) throws SQLException {
       return classDao.getStudentClasses(student_id);

    }
}
