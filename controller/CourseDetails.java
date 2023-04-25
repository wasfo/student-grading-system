package com.example.StudentGradingSystem.controller;


import com.example.StudentGradingSystem.data.CourseDao;
import com.example.StudentGradingSystem.models.Course;
import com.example.StudentGradingSystem.service.CourseService;
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
@RequestMapping("/course")
public class CourseDetails {
    @Autowired
    CourseService courseService;

    public CourseDetails() throws SQLException {
    }


    @GetMapping("/{courseId}/{studentId}")
    public String viewCourseDetails(@PathVariable("courseId") int courseId, @PathVariable("studentId")
    int studentId, Model model, HttpServletRequest request) throws SQLException {

        HttpSession session = request.getSession(false);
        if(session == null){
            return "loginChoice";
        }
        Course course = courseService.getCourseById(courseId);
        Double grade = courseService.getStudentGradeInACourse(courseId, studentId);
        model.addAttribute("studentId",studentId);
        model.addAttribute("courseName", course.getCourseName());
        model.addAttribute("courseAMHL", course.getCourse_amhl());
        model.addAttribute("grade", grade);
        return "courseInfo";
    }

}
