package com.thandekadior.backoffice.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {
    private int id;
    private int userId;
    private BigDecimal amount;
    private String description;
    private Timestamp createdAt;

    public Transaction(int id, int userId, BigDecimal amount, String description, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.description = description;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public BigDecimal getAmount() { return amount; }
    public String getDescription() { return description; }
    public Timestamp getCreatedAt() { return createdAt; }
}
