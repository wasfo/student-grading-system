package com.example.StudentGradingSystem.data;


import com.example.StudentGradingSystem.models.Student;

import java.sql.*;

public class RegistrationDao {

    Connection connection = new DBConnection().getConnection();
    public RegistrationDao(){}

    public void registerStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (studentName, studentEmailAddress,gender, studentLastName, birthDate,major,country)\n" +
                "VALUES(?,?,?,?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, student.getStudentInfo().getFirstName());
        preparedStatement.setString(2, student.getStudentInfo().getEmailAddress());
        preparedStatement.setString(3, student.getStudentInfo().getGender());
        preparedStatement.setString(4, student.getStudentInfo().getLastName());
        preparedStatement.setString(5, student.getStudentInfo().getLastName());
        preparedStatement.setString(6, student.getStudentInfo().getMajor());
        preparedStatement.setString(7, student.getStudentInfo().getCountry());
        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int newId = generatedKeys.getInt(1);
            System.out.println("New record ID: " + newId);
            registerAccount(student,newId);
        }

    }
    public void registerAccount(Student student, int studentID) throws SQLException {
        String sql = "INSERT INTO studentaccounts (username,password,studentID)\n" +
                "VALUES(?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getStudentAccount().getUsername());
        preparedStatement.setString(2, student.getStudentAccount().getPassword());
        preparedStatement.setString(3, String.valueOf(studentID));
        preparedStatement.executeUpdate();
    }
}
