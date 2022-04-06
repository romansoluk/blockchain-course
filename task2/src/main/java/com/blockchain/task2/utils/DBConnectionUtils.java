package com.blockchain.task2.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnectionUtils {

    @Value(value = "${spring.datasource.username}")
    private static String username;

    @Value(value = "${spring.datasource.password}")
    private static String password;

    @Value(value = "${spring.datasource.url}")
    private static String urlConn;


    public static Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", username);
        connectionProps.put("password", password);
        conn = DriverManager.getConnection(urlConn, connectionProps);
        return conn;
    }

}
