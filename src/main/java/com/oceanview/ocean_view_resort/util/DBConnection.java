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

    static {
        try {
            Properties properties = new Properties();
            InputStream input = DBConnection.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties");

            if (input == null) {
                throw new RuntimeException("Error: application.properties file not found in resources!");
            }

            properties.load(input);

            HikariConfig config = new HikariConfig();


            config.setDriverClassName("com.mysql.cj.jdbc.Driver");

            config.setJdbcUrl(properties.getProperty("db.url"));
            config.setUsername(properties.getProperty("db.username"));
            config.setPassword(properties.getProperty("db.password"));

            config.setMaximumPoolSize(10);
            config.setMinimumIdle(2);
            config.setIdleTimeout(30000);


            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");

            dataSource = new HikariDataSource(config);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load DB properties", e);
        }
    }

    private DBConnection() { }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSource is not initialized properly!");
        }
        return dataSource.getConnection();
    }
}