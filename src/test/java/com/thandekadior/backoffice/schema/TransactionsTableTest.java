package com.thandekadior.backoffice.schema;

import com.thandekadior.backoffice.config.DatabaseConfig;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionsTableTest {
    @Test
    void testTransactionsTableHasData() throws Exception {
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM transactions")) {

            rs.next();
            int count = rs.getInt(1);
            assertTrue(count > 0, "Transactions table should have at least one row");
        }
    }
}
