package com.example.StudentGradingSystem.data;
import com.example.StudentGradingSystem.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseDao {
    Connection connection = new DBConnection().getConnection();

    public CourseDao() throws SQLException {
    }


    public List<Course> getStudentCourses(int student_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT course.*\n" +
                "FROM course\n" +
                "JOIN class ON course.id = class.CourseID\n" +
                "JOIN studentclasses ON class.id = studentclasses.ClassID\n" +
                "WHERE studentclasses.studentID = ? \n");
        preparedStatement.setInt(1, student_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Course> CourseList = new ArrayList<>();
        while (resultSet.next()) {
            Course course = Course.builder()
                    .courseName(resultSet.getString(2))
                    .id(Integer.parseInt(resultSet.getString(1)))
                    .build();
            CourseList.add(course);
        }
        return CourseList;
    }

    public Course getCourseById(int course_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE id = ?");
        preparedStatement.setInt(1, course_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return Course.builder()
                .course_amhl(getCourseAMHL(course_id))
                .courseName(resultSet.getString("courseName"))
                .build();
    }


    public Course_AMHL getCourseAMHL(int course_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM grades WHERE coursID = ?");
        preparedStatement.setInt(1, course_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> grades = new ArrayList<>();
        while (resultSet.next()) {
            grades.add(Integer.parseInt(resultSet.getString("finalGrade")));

        }
        int min = 0;
        int max = 0;
        double median = 0;
        double avg = 0;
        try {
             min = Collections.min(grades);
             max = Collections.max(grades);
            int n = grades.size();
            if (n % 2 == 0) {
                median = (double) (grades.get(n / 2 - 1) + grades.get(n / 2)) / 2.0;
            } else {
                median = (double) grades.get(n / 2);
            }
            double sum = 0;
            for (int num : grades) {
                sum += num;
            }
             avg = sum / n;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Course_AMHL.builder()
                .avg(avg)
                .highest(max)
                .lowest(min)
                .median(median)
                .build();
    }

    public Double getStudentGradeInACourse(int course_id, int student_id) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM grades WHERE coursID = ? AND studenID = ?");
            preparedStatement.setInt(1, course_id);
            preparedStatement.setInt(2, student_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return (Double.parseDouble(resultSet.getString("finalGrade")));
            }
        } catch (NumberFormatException | SQLException e) {
            throw new RuntimeException(e);
        }
        return Double.NaN;
    }
}
