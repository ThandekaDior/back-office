package com.thandekadior.backoffice.dto;

import java.math.BigDecimal;

public class UserSpendDTO {
    private int id;
    private String name;
    private String email;
    private String createdAt;
    private BigDecimal totalSpend;

    public UserSpendDTO(int id, String name, String email, String createdAt, BigDecimal totalSpend) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.totalSpend = totalSpend;
    }

    //getters only (for jackson)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCreatedAt() { return createdAt; }
    public BigDecimal getTotalSpend() { return totalSpend; }
}
