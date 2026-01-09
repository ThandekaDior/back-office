package com.thandekadior.backoffice;

import com.thandekadior.backoffice.model.Transaction;
import com.thandekadior.backoffice.service.TransactionService;
import com.thandekadior.backoffice.service.UserService;
import com.thandekadior.backoffice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("..back office running.");

        //users
        UserService userService = new UserService();
        List<User> users = userService.listUsers();

        for (User user : users) {
            logger.info("User: {} - {}", user.getId(), user.getName());
        }

        //transactions
        TransactionService transactionService = new TransactionService();
        for (Transaction tx : transactionService.listTransactions()) {
            logger.info("Transaction: {} | User {} | {} | {}",
                    tx.getId(), tx.getUserId(), tx.getAmount(), tx.getDescription());
        }

    }
}
