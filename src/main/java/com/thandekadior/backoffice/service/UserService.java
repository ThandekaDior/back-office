package com.thandekadior.backoffice.service;

import com.thandekadior.backoffice.dao.UserDAO;
import com.thandekadior.backoffice.model.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public List<User> listUsers() {
        return userDAO.getAllUsers();
    }
}
