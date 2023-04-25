package com.example.StudentGradingSystem.data;

import com.example.StudentGradingSystem.models.*;


import java.sql.*;

public class StudentDao {
    Connection connection = new DBConnection().getConnection();

    public StudentInfo getStudentInfo(int student_id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, student_id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        String firstname = rs.getString(2);
        String email = rs.getString(3);
        String lastname = rs.getString(4);
        String birthdate = rs.getString(5);
        String gender = rs.getString(6);
        String major = rs.getString(7);
        String country = rs.getString(8);

        return new StudentInfo(firstname, email, lastname, birthdate, gender, major, country);
    }

}
