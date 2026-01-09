package com.thandekadior.backoffice.service;

import com.thandekadior.backoffice.dao.TransactionDAO;
import com.thandekadior.backoffice.model.Transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionDAO transactionDAO = new TransactionDAO();

    public List<Transaction> listTransactions() {
        return transactionDAO.getAllTransactions();
    }
}
