package com.example.StudentGradingSystem.service;

import com.example.StudentGradingSystem.data.AccountDao;
import com.example.StudentGradingSystem.models.Account;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AccountService {
    AccountDao accountDao = new AccountDao();

    public boolean isValidAccount(Account account) throws SQLException, ClassNotFoundException {
        return accountDao.isAccountPresent(account);
    }
    public int getStudentId(Account account) throws SQLException, ClassNotFoundException {
        return accountDao.getStudentId(account);
    }



}
