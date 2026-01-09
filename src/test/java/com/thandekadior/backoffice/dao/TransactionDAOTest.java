package com.thandekadior.backoffice.dao;

import com.thandekadior.backoffice.model.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransactionDAOTest {
    @Test
    void testGetAllTransactionsReturnsList() {
        TransactionDAO dao = new TransactionDAO();
        List<Transaction> transactions = dao.getAllTransactions();
        assertNotNull(transactions, "Transaction list should not be null");
    }
}
