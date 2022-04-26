package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionBook {

    public static Connection getConnection(){
        Connection connection = null;

        try {
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Books","postgres","Zuvyte");
            if (connection != null) System.out.println("Connection successful!");
        }catch (SQLException e){
            System.out.println("The was a problem connecting to the database");
            e.printStackTrace();
        }
        return connection;
    }
}
