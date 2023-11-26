/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;



public class DB {
    
    public static Connection connection = null;
    
    public static Connection connectMySql() throws SQLException{
        
        String url = "jdbc:mysql://localhost:3306/btSys";
        String username = "root"; // Connection user name
        String password = "Falcon2025adam1"; // connection password
        
        connection = DriverManager.getConnection(url, username, password);
        
        return connection;
    }
}