package com.example.StudentGradingSystem.data;



import com.example.StudentGradingSystem.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

    Connection connection = new DBConnection().getConnection();

    public AccountDao() {
    }
    public Boolean isAccountPresent(Account account) throws SQLException, ClassNotFoundException {
        ResultSet rs = accountQuery(account);
        return rs.next();
    }

    public int getStudentId(Account account) throws SQLException, ClassNotFoundException {
        ResultSet rs = accountQuery(account);
        rs.next();
        return rs.getInt("studentID");
    }

    private ResultSet accountQuery(Account account) throws SQLException {
        String userName = account.getUsername();
        String password = account.getPassword();
        String sql = "select * from studentAccounts where username=? and password= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        return rs;
    }
}
