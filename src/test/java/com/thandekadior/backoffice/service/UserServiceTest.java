package com.thandekadior.backoffice.service;

import com.thandekadior.backoffice.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {
    @Test
    void testListUsersReturnsList() {
        UserService service = new UserService();
        List<User> users = service.listUsers();
        assertNotNull(users, "Service should return a list of users");
    }
}
