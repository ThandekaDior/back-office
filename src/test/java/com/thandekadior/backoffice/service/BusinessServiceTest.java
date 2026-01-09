package com.thandekadior.backoffice.service;

import com.thandekadior.backoffice.model.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessServiceTest {

    @Test
    void testCalculateTotalSpendPerUser() {
        BusinessService service = new BusinessService();
        Map<User, BigDecimal> totals = service.calculateTotalSpendPerUser();

        assertNotNull(totals, "Totals should not be null");
        assertTrue(totals.size() > 0, "Should calculate totals for at least one user");
    }

    @Test
    void testTopUsersBySpend() {
        BusinessService service = new BusinessService();
        var topUsers = service.topUsersBySpend(2);

        assertNotNull(topUsers, "Top users list should not be null");
        assertTrue(topUsers.size() <= 2, "Should return at most 2 users");
    }
}
