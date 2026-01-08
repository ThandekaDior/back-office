package com.thandekadior.backoffice;

import com.thandekadior.backoffice.config.DatabaseConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("..back office running.");
        logger.debug("debug details:");
        logger.error("error messages:");

        //try connecting to neon
        try (Connection conn = DatabaseConfig.getConnection("prod")) {
            logger.info("Connected to Neon successfully!");
        } catch (Exception e) {
            logger.error("Failed to connect to Neon", e);
        }
    }
}
