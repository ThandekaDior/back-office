//package com.thandekadior.backoffice;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class NeonCheck {
//    public static void main(String[] args) throws Exception {
//        String url = "jdbc:postgresql://ep-small-frog-ad2rks2j-pooler.c-2.us-east-1.aws.neon.tech:5432/neondb?sslmode=require";
//        String user = "neondb_owner";
//        String password = "npg_AyPagF27vkCG";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            System.out.println("successfully connected to Neon");
//        }
//    }
//}
