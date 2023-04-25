package com.example.demo.service;

import java.sql.*;

public class Jdbc {
    public static Connection JdbcConnect() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/ooad_mvc_pes1ug20cs213";
        String usn = "root";
        String pw="";
        return  DriverManager.getConnection(url, usn, pw);

    }
}
