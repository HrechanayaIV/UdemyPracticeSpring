package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TeatJDBC {
    public static void main(String[] args) {
        //String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "root";
        String pass = "root";
        try {
            System.out.println("connecting to DB: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
