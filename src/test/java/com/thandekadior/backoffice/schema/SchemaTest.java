package com.thandekadior.backoffice.schema;

import com.thandekadior.backoffice.config.DatabaseConfig;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchemaTest {
    @Test
    void testTablesExist() throws Exception {
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rsUsers = stmt.executeQuery(
                    "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'users')");
            rsUsers.next();
            assertTrue(rsUsers.getBoolean(1), "Users table should exist");

            ResultSet rsTransactions = stmt.executeQuery(
                    "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'transactions')");
            rsTransactions.next();
            assertTrue(rsTransactions.getBoolean(1), "Transactions table should exist");
        }
    }
}
