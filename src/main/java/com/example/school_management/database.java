package com.example.school_management;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.sql.*;

public class database extends School {
    public static Connection connectDB() {
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
    public void notice_update(String img_path,String y)
    {
        Connection connect;
        PreparedStatement prepare;
        Statement statement;
        ResultSet result;
        try
        {

            img_path=img_path.replace("\\","\\\\\\\\");
            connect=database.connectDB();
            String sql="UPDATE notice_data SET `path` = '"+img_path+"' WHERE `no` = '" +y+ "'";
            //  System.out.println(sql);
            statement=connect.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e)
        {
            System.out.println("notice database error");
        }
    }
    public String notice_render(String s)
    {
        Connection connect;
        PreparedStatement prepare;
        Statement statement;
        ResultSet result;
        connect=database.connectDB();
        String sql="SELECT * FROM notice_data WHERE no = '"+s+"'";
        try {
            prepare = connect.prepareStatement(sql);
            // prepare.setString(1 , "1");
            result = prepare.executeQuery();
            if(result.next())
            {
                return result.getString("path");
            }
        } catch (Exception e)
        {
            System.out.println("notice access error");
        }
        return "null";
    }


}
