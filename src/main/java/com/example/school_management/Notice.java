package com.example.school_management;

import com.example.crud.People;
import com.example.crud.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Notice extends database {
    public void notice_update(String img_path,String y,String lbl,String date)
    {
        Connection connect = null;
        PreparedStatement prepare = null;
        Statement statement = null;
        ResultSet result = null;
        try
        {

            img_path=img_path.replace("\\","\\\\\\\\");
            connect=database.connectDB();
            String sql="UPDATE notice_data SET `path` = '"+img_path+"', `label` = '"+lbl+"', `date` = '"+date+"' WHERE `no` = '" +y+ "'";
           // System.out.println(sql);
            statement=connect.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e)
        {
            System.out.println("notice database error");
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
    public String notice_render(String s)
    {
        Connection connect = null;
        PreparedStatement prepare = null;
        Statement statement = null;
        ResultSet result = null;

        String sql="SELECT * FROM notice_data WHERE no = '"+s+"'";
        try {
            connect=database.connectDB();
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
    public ObservableList<String> da()
    {
        Connection connect;
        PreparedStatement prepare;
        Statement statement;
        ResultSet result;
        ObservableList<String> da = FXCollections.observableArrayList();
        String sql="SELECT * FROM notice_data";

        try {
            connect= database.connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();
            People people;

            while(result.next())
            {
                da.add(result.getString("label"));
            }

        }catch (Exception e) {
            System.out.println("noitce lebel database error");
        }

        return da;
    }
    public ObservableList<String> date()
    {
        Connection connect;
        PreparedStatement prepare;
        Statement statement;
        ResultSet result;
        ObservableList<String> da = FXCollections.observableArrayList();
        String sql="SELECT * FROM notice_data";

        try {
            connect= database.connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();
            People people;

            while(result.next())
            {
                da.add(result.getString("date"));
            }

        }catch (Exception e) {
            System.out.println("noitce date database error");
        }
        return da;
    }

}
