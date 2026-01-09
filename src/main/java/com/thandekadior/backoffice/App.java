//package com.thandekadior.backoffice;
//
//import com.thandekadior.backoffice.model.Transaction;
//import com.thandekadior.backoffice.service.BusinessService;
//import com.thandekadior.backoffice.service.TransactionService;
//import com.thandekadior.backoffice.service.UserService;
//import com.thandekadior.backoffice.model.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Map;
//
//public class App {
//    private static final Logger logger = LoggerFactory.getLogger(App.class);
//
//    public static void main(String[] args) {
//        logger.info("..back office running.");
//
//        //users
//        UserService userService = new UserService();
//        List<User> users = userService.listUsers();
//
//        for (User user : users) {
//            logger.info("User: {} - {} | {} | {}", user.getId(), user.getName(), user.getEmail(), user.getCreatedAt());
//        }
//
//        //transactions
//        TransactionService transactionService = new TransactionService();
//        for (Transaction tx : transactionService.listTransactions()) {
//            logger.info("Transaction: {} | User {} | {} | {}",
//                    tx.getId(), tx.getUserId(), tx.getAmount(), tx.getDescription());
//        }
//
//        //join query - users with transactions
//        Map<User, List<Transaction>> userTxMap = userService.listUsersWithTransactions();
//        for (Map.Entry<User, List<Transaction>> entry : userTxMap.entrySet()) {
//            User user = entry.getKey();
//            List<Transaction> txs = entry.getValue();
//
//            logger.info("User: {} - {} ({} transactions)",
//                    user.getId(), user.getName(), txs.size());
//
//            for (Transaction tx : txs) {
//                logger.info(" Transaction {} | {} | {}",
//                        tx.getId(), tx.getAmount(), tx.getDescription());
//            }
//        }
//
//        BusinessService businessService = new BusinessService();
//
//        //total spend per user
//        Map<User, BigDecimal> totals = businessService.calculateTotalSpendPerUser();
//        for (Map.Entry<User, BigDecimal> entry : totals.entrySet()) {
//            User user = entry.getKey();
//            BigDecimal total = entry.getValue();
//            logger.info("User: {} - {} | Total Spend: {}",
//                    user.getId(), user.getName(), total);
//        }
//
//        //top 2 users by spend
//        List<Map.Entry<User, BigDecimal>> topUsers = businessService.topUsersBySpend(2);
//        logger.info("Top spenders:");
//        for (Map.Entry<User, BigDecimal> entry : topUsers) {
//            logger.info("   {} - {} | {}",
//                    entry.getKey().getId(), entry.getKey().getName(), entry.getValue());
//        }
//
//
//    }
//}

package com.thandekadior.backoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
