package com.example.StudentGradingSystem.controller;
import com.example.StudentGradingSystem.service.ClassService;
import com.example.StudentGradingSystem.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.SQLException;

@Controller
@RequestMapping("/Dashboard")
public class DashboardController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @GetMapping
    public String viewDashboard() {
        return "redirect:/login/student";
    }

    @GetMapping("/{studentId}")
    public String viewStudentInfo(@PathVariable int studentId, Model model, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if(session == null){
            return "loginChoice";
        }
        session.setAttribute("studentId",studentId);
        model.addAttribute("classesList", classService.getStudentClasses(studentId));
        model.addAttribute("student_id", studentId);
        model.addAttribute("student", studentService.getStudentInfo(studentId));
        return "studentInfo";
    }


}