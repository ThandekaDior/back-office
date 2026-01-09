package com.thandekadior.backoffice.service;

import com.thandekadior.backoffice.model.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransactionServiceTest {
    @Test
    void testListTransactionsReturnsList() {
        TransactionService service = new TransactionService();
        List<Transaction> transactions = service.listTransactions();
        assertNotNull(transactions, "Service should return a list of transactions");
    }
}
