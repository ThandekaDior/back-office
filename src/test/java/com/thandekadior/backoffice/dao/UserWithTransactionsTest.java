package com.thandekadior.backoffice.dao;

import com.thandekadior.backoffice.model.User;
import com.thandekadior.backoffice.model.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserWithTransactionsTest {
    @Test
    void testGetUsersWithTransactionsReturnsMap() {
        UserDAO dao = new UserDAO();
        Map<User, List<Transaction>> userTxMap = dao.getUsersWithTransactions();
        assertNotNull(userTxMap, "Map should not be null");
        assertTrue(userTxMap.size() > 0, "Should return at least one user");
    }
}
