package com.thandekadior.backoffice.service;

import com.thandekadior.backoffice.dao.UserDAO;
import com.thandekadior.backoffice.model.User;
import com.thandekadior.backoffice.model.Transaction;

import java.math.BigDecimal;
import java.util.*;

public class BusinessService {
    private final UserDAO userDAO = new UserDAO();

    //total spend per user
    public Map<User, BigDecimal> calculateTotalSpendPerUser() {
        Map<User, List<Transaction>> userTxMap = userDAO.getUsersWithTransactions();
        Map<User, BigDecimal> totals = new HashMap<>();

        for (Map.Entry<User, List<Transaction>> entry : userTxMap.entrySet()) {
            User user = entry.getKey();
            List<Transaction> txs = entry.getValue();

            BigDecimal total = txs.stream()
                    .map(Transaction::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            totals.put(user, total);
        }
        return totals;
    }

    //for example: find top N users by spend
    public List<Map.Entry<User, BigDecimal>> topUsersBySpend(int n) {
        Map<User, BigDecimal> totals = calculateTotalSpendPerUser();
        return totals.entrySet().stream()
                .sorted(Map.Entry.<User, BigDecimal>comparingByValue().reversed())
                .limit(n)
                .toList();
    }
}
