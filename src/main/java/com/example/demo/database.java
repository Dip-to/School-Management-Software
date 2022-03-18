package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static Connection connectDB() throws ClassNotFoundException {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect= DriverManager.getConnection("jdbc:mysql://localhost/school_management","root","");
            if(connect==null)
            {
                System.out.println("database load error");
            }
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("database load error");
        }
        return null;
    }

}
