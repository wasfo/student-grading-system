package com.example.StudentGradingSystem.service;


import com.example.StudentGradingSystem.data.RegistrationDao;
import com.example.StudentGradingSystem.models.Student;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RegisterService {
    RegistrationDao registrationDao = new RegistrationDao();

    public void registerStudent(Student student) throws SQLException {
        registrationDao.registerStudent(student);
    }

}
