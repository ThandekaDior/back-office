package com.thandekadior.backoffice.service;

import com.thandekadior.backoffice.dao.TransactionDAO;
import com.thandekadior.backoffice.model.Transaction;

import java.util.List;

public class TransactionService {
    private final TransactionDAO transactionDAO = new TransactionDAO();

    public List<Transaction> listTransactions() {
        return transactionDAO.getAllTransactions();
    }
}
