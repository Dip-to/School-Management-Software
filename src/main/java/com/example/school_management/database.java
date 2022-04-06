package com.example.school_management;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.sql.*;

public class database extends School {
    public static Connection connectDB() {
        try
        {
            
            Class.forName("org.sqlite.JDBC");
            Connection connect= DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/example/school_management/database/school_management.db");
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
        Connection connect = null;
        PreparedStatement prepare = null;
        Statement statement = null;
        ResultSet result = null;
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
        finally
        {
            try
            {
                connect.close();
                result.close();
                prepare.close();
                statement.close();

            }catch (Exception e)
            {

            }
        }

    }
    public String classroom_render(String s)
    {
        Connection connect= null;
        PreparedStatement prepare = null;
        Statement statement = null;
        ResultSet result = null;
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
        finally
        {
            try
            {
                connect.close();
                result.close();
                prepare.close();
                statement.close();

            }catch (Exception e)
            {

            }
        }
        return "null";
    }


}
