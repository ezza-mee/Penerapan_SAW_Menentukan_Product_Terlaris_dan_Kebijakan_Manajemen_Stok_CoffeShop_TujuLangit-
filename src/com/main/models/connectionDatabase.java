package com.main.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDatabase {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/tujulangit_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
