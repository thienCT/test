package com.example.playerevaluation.Database;

import java.sql.*;

public class database {
    private final String connectionString = "jdbc:mysql://localhost:3306/player_evaluation";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection conn;
    private static database _instance;
    private database(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(connectionString,user,password);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static database createInstance(){
        if(_instance == null){
            _instance = new database();
        }
        return _instance;
    }

    public Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

    public PreparedStatement getPrepareStatement(String sql) throws SQLException{
        return conn.prepareStatement(sql);
    }
}