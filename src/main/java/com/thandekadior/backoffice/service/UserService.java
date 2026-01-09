package com.thandekadior.backoffice.service;

import com.thandekadior.backoffice.dao.UserDAO;
import com.thandekadior.backoffice.model.Transaction;
import com.thandekadior.backoffice.model.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public List<User> listUsers() {
        return userDAO.getAllUsers();
    }

    public Map<User, List<Transaction>> listUsersWithTransactions() {
        return userDAO.getUsersWithTransactions();
    }

}
