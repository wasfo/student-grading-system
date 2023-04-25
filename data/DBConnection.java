package com.example.StudentGradingSystem.data;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public  Connection getConnection()
    {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/gradingsystem";
        String username = "root";
        String password = "12321";
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}