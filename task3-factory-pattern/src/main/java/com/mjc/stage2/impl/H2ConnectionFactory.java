package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import org.h2.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection connection = null;
        Properties properties = new Properties();

        try {
            properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
            String driver = properties.getProperty("jdbc_driver");
            String url = properties.getProperty("db_url");
            String uname = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, uname, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

