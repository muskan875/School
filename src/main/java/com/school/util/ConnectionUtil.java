package com.school.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	static Connection con = null;
    static String url = "jdbc:postgresql://localhost:5432/postgres"; // PostgreSQL URL
    static String user = "postgres"; // PostgreSQL username
    static String pass = "password"; // PostgreSQL password

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver"); // PostgreSQL driver class
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}