package com.thandekadior.backoffice.config;

import org.junit.jupiter.api.Test;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseConfigTest {
    @Test
    void testConnectionNotNull() throws Exception {
        try (Connection conn = DatabaseConfig.getConnection()) {
            assertNotNull(conn, "Connection should not be null");
        }
    }
}
