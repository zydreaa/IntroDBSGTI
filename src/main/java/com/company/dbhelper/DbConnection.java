package com.company.dbhelper;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    //Create one static method to return the connection to the database
    //via the jdbc. it is a static method because we do  not need multiple connections
    //or instances to the database

    public static Connection getConnection(){
       Connection connection = null;

        try {
           connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/students","postgres","Zuvyte");
           if (connection != null) System.out.println("Connection successful!");
       }catch (SQLException e){
            System.out.println("The was a problem connecting to the database");
            e.printStackTrace();
       }
        return connection;
    }
}
