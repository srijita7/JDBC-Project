package com.examly.springapp.dao;
import java.sql.*;

public class JDBCUtils
{
    
    public static final String URL="jdbc:mysql://localhost:3306/appdb";
    public static final String USERNAME="root";
    public static final String PASSWORD="examly";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
}