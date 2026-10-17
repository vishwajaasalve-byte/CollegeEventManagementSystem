package com.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This connection must match database.sql:
 * database: college_events
 * table: registrations
 *
 * Set DB_PASSWORD to your local MySQL root password, or replace the
 * fallback value below with that password before running the project.
 */
public class DB {
    private static final String URL = System.getenv().getOrDefault(
        "DB_URL",
        "jdbc:mysql://localhost:3306/college_events?useSSL=false&serverTimezone=UTC"
    );
    private static final String USER = System.getenv().getOrDefault("DB_USER", "root");
    private static final String PASSWORD = System.getenv().getOrDefault(
        "DB_PASSWORD",
        "YOUR_MYSQL_PASSWORD"
    );

    public static Connection getConnection() throws SQLException {
        if ("YOUR_MYSQL_PASSWORD".equals(PASSWORD)) {
            throw new SQLException(
                "Set DB_PASSWORD to your MySQL password, or update the PASSWORD fallback in DB.java."
            );
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
