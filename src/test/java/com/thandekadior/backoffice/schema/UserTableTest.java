package com.thandekadior.backoffice.schema;

import com.thandekadior.backoffice.config.DatabaseConfig;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTableTest {
    @Test
    void testUsersTableHasData() throws Exception {
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM users")) {

            rs.next();
            int count = rs.getInt(1);
            assertTrue(count > 0, "Users table should have at least one row");
        }
    }
}
