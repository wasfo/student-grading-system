package com.example.StudentGradingSystem.data;

import com.example.StudentGradingSystem.models.SchoolClass;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDao {
    Connection connection = new DBConnection().getConnection();
    public List<SchoolClass> getStudentClasses(int student_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT class.*\n" +
                "FROM class\n" +
                "INNER JOIN studentclasses\n" +
                "ON class.id = studentclasses.classID\n" +
                "WHERE studentclasses.studentID = ?;\n");
        preparedStatement.setInt(1, student_id);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<SchoolClass> classList = new ArrayList<>();
        while (resultSet.next()) {
            String instructorName = getInstructorName(resultSet.getInt("InstructorID"));
            String className = resultSet.getString("className");
            String time = resultSet.getString("time");
            String location = resultSet.getString("location");
            int course_id = resultSet.getInt("CourseID");
            SchoolClass schoolClass = SchoolClass.builder()
                    .className(className)
                    .course_id(course_id)
                    .instructorName(instructorName)
                    .time(time)
                    .location(location)
                    .build();

            classList.add(schoolClass);
        }
        return classList;
    }

    public String getInstructorName(int instructor_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM instructors WHERE id = ?");
        preparedStatement.setInt(1, instructor_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("instructorName");
    }
}
