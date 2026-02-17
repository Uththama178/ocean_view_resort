package com.oceanview.ocean_view_resort.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static HikariDataSource dataSource;

    // Static block - runs only once
    static {
        try {
            Properties properties = new Properties();
            InputStream input = DBConnection.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties");

            properties.load(input);

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(properties.getProperty("db.url"));
            config.setUsername(properties.getProperty("db.username"));
            config.setPassword(properties.getProperty("db.password"));

            config.setMaximumPoolSize(10); // max 10 connections
            config.setMinimumIdle(2);
            config.setIdleTimeout(30000);

            dataSource = new HikariDataSource(config);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load DB properties", e);
        }
    }

    private DBConnection() {
        // prevent object creation
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

