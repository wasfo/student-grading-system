package com.example.StudentGradingSystem.controller;


import com.example.StudentGradingSystem.models.Account;
import com.example.StudentGradingSystem.models.Student;
import com.example.StudentGradingSystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    RegisterService registerService;

    @GetMapping
    public String viewRegistrationForm() {
        return "registration";
    }

    @PostMapping("/save")
    public String registerStudent(@ModelAttribute("studentData") Student studentData,
                                  @RequestParam("password") String pass,
                                  @RequestParam("confirmpassword") String conPass) throws SQLException {

        System.out.println(pass);
        System.out.println(conPass);
        System.out.println("student DATA ");
        if (pass.equals(conPass)) {
            Student student = Student.builder()
                    .studentInfo(studentData.getStudentInfo())
                    .studentAccount(new Account(studentData.getStudentInfo().getFirstName(), pass))
                    .build();
            registerService.registerStudent(student);
        }
// th:action="@{/register/save}"

        return "loginChoice";
    }
}
