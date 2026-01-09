package com.thandekadior.backoffice.dao;

import com.thandekadior.backoffice.model.Transaction;
import com.thandekadior.backoffice.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDAOTest {
    @Test
    void testGetAllUsersReturnsList() {
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();
        assertNotNull(users, "User list should not be null");
    }
}
