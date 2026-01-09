package com.thandekadior.backoffice.model;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String email;
    private Timestamp createdAt;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id, String name, String email, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override public int hashCode() {
        return Objects.hash(id);
    }
}
