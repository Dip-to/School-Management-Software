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
    public void classroom(String img_path,int y)
    {
        Connection connect;
        PreparedStatement prepare;
        Statement statement;
        ResultSet result;
        try
        {

            img_path=img_path.replace("\\","\\\\\\\\");
            connect=database.connectDB();
            String sql="UPDATE classroom_data SET `image` = '"+img_path+"' WHERE `class` = '" +y+ "'";
            //System.out.println(sql);
            statement=connect.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e)
        {
            System.out.println("classes database error");
        }
    }
    public String classroom_render(String s)
    {
        Connection connect;
        PreparedStatement prepare;
        Statement statement;
        ResultSet result;
        connect=database.connectDB();
        String sql="SELECT * FROM classroom_data WHERE class = '"+s+"'";
        try {
            prepare = connect.prepareStatement(sql);
            // prepare.setString(1 , "1");
            result = prepare.executeQuery();
            if(result.next())
            {
                return result.getString("image");
            }
        } catch (Exception e)
        {
            System.out.println("classroom database access error");
        }
        return "null";
    }


}
