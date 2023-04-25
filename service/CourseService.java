package com.example.StudentGradingSystem.service;

import com.example.StudentGradingSystem.data.CourseDao;
import com.example.StudentGradingSystem.models.Course;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
public class CourseService {

    CourseDao courseDao = new CourseDao();

    public CourseService() throws SQLException {
    }

    public Course getCourseById(int courseId) throws SQLException {
       return courseDao.getCourseById(courseId);
    }
    public Double getStudentGradeInACourse(int courseId, int studentId) throws SQLException {
        return courseDao.getStudentGradeInACourse(courseId,studentId);
    }
}
