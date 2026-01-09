package com.thandekadior.backoffice.dao;

import com.thandekadior.backoffice.config.DatabaseConfig;
import com.thandekadior.backoffice.model.User;
import com.thandekadior.backoffice.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class UserDAO {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id, name, email, created_at FROM users");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getTimestamp("created_at")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    //users with their transactions
    public Map<User, List<Transaction>> getUsersWithTransactions() {
        Map<User, List<Transaction>> result = new HashMap<>();

        String sql = "SELECT u.id AS user_id, u.name, u.email, " +
                "t.id AS tx_id, t.amount, t.description, t.created_at " +
                "FROM users u LEFT JOIN transactions t ON u.id = t.user_id " +
                "ORDER BY u.id";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                //build user object
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getTimestamp("created_at")
                );
                //for if user model has email, this works
                // user.setEmail(rs.getString("email"));

                //build transaction object if present
                Transaction tx = null;
                if (rs.getInt("tx_id") != 0) {
                    tx = new Transaction(
                            rs.getInt("tx_id"),
                            rs.getInt("user_id"),
                            rs.getBigDecimal("amount"),
                            rs.getString("description"),
                            rs.getTimestamp("created_at")
                    );
                }

                //group transactions under the user
                result.computeIfAbsent(user, k -> new ArrayList<>());
                if (tx != null) {
                    result.get(user).add(tx);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
