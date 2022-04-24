package com.example.controller;

import com.example.crud.Teacher;
import com.example.school_management.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClassesController implements Initializable {
    @FXML
    private AnchorPane class_main;

    @FXML
    private ComboBox<?> mon_sub_1;

    @FXML
    private ComboBox<?> mon_sub_2;

    @FXML
    private ComboBox<?> mon_sub_3;

    @FXML
    private ComboBox<?> mon_sub_4;

    @FXML
    private ComboBox<?> mon_sub_5;

    @FXML
    private ComboBox<?> mon_teach_1;

    @FXML
    private ComboBox<?> mon_teach_2;

    @FXML
    private ComboBox<?> mon_teach_3;

    @FXML
    private ComboBox<?> mon_teach_4;

    @FXML
    private ComboBox<?> mon_teach_5;

    @FXML
    private ComboBox<?> sun_sub_1;

    @FXML
    private ComboBox<?> sun_sub_2;

    @FXML
    private ComboBox<?> sun_sub_3;

    @FXML
    private ComboBox<?> sun_sub_4;

    @FXML
    private ComboBox<?> sun_sub_5;

    @FXML
    private ComboBox<?> sun_teach_1;

    @FXML
    private ComboBox<?> sun_teach_2;

    @FXML
    private ComboBox<?> sun_teach_3;

    @FXML
    private ComboBox<?> sun_teach_4;

    @FXML
    private ComboBox<?> sun_teach_5;

    @FXML
    private ComboBox<?> thur_sub_1;

    @FXML
    private ComboBox<?> thur_sub_2;

    @FXML
    private ComboBox<?> thur_sub_3;

    @FXML
    private ComboBox<?> thur_sub_4;

    @FXML
    private ComboBox<?> thur_sub_5;

    @FXML
    private ComboBox<?> thur_teach_1;

    @FXML
    private ComboBox<?> thur_teach_2;

    @FXML
    private ComboBox<?> thur_teach_3;

    @FXML
    private ComboBox<?> thur_teach_4;

    @FXML
    private ComboBox<?> thur_teach_5;

    @FXML
    private ComboBox<?> tue_sub_1;

    @FXML
    private ComboBox<?> tue_sub_2;

    @FXML
    private ComboBox<?> tue_sub_3;

    @FXML
    private ComboBox<?> tue_sub_4;

    @FXML
    private ComboBox<?> tue_sub_5;

    @FXML
    private ComboBox<?> tue_teach_1;

    @FXML
    private ComboBox<?> tue_teach_2;

    @FXML
    private ComboBox<?> tue_teach_3;

    @FXML
    private ComboBox<?> tue_teach_4;

    @FXML
    private ComboBox<?> tue_teach_5;

    @FXML
    private ComboBox<?> wed_sub_1;

    @FXML
    private ComboBox<?> wed_sub_2;

    @FXML
    private ComboBox<?> wed_sub_3;

    @FXML
    private ComboBox<?> wed_sub_4;

    @FXML
    private ComboBox<?> wed_sub_5;

    @FXML
    private ComboBox<?> wed_teach_1;

    @FXML
    private ComboBox<?> wed_teach_2;

    @FXML
    private ComboBox<?> wed_teach_3;

    @FXML
    private ComboBox<?> wed_teach_4;

    @FXML
    private ComboBox<?> wed_teach_5;

    private String[] Combo_sub={"Bangla","English","Math","Physics"};
    private String[] Combo_teacher={};

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    @FXML
    public  ObservableList  add_tchr(String s)
    {

        List<String> list=new ArrayList<>();
        ObservableList data_list = null;
       // s="Physics";
        Combo_teacher=null;
        String sql;
        sql ="SELECT * FROM teacher_data WHERE `subject` = '"+s+"'";
        try {
            connect= database.connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while(result.next())
            {
                list.add(result.getString("name"));
            }
            data_list= FXCollections.observableArrayList(list);
            //sun_teach_1.setItems(data_list);
        }catch (Exception e) {
            System.out.println("teacher routine database error");
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
        return data_list;

    }
    public void s1()
    {

        String str=null;
        str= (String) sun_sub_1.getSelectionModel().getSelectedItem();
        sun_teach_1.getSelectionModel().clearSelection();
        sun_teach_1.setItems(add_tchr(str));

    }

    public void s2()
    {

        String str=null;
        str= (String) sun_sub_2.getSelectionModel().getSelectedItem();
        sun_teach_2.getSelectionModel().clearSelection();
        sun_teach_2.setItems(add_tchr(str));

    }

    public void s3()
    {

        String str=null;
        str= (String) sun_sub_3.getSelectionModel().getSelectedItem();
        sun_teach_3.getSelectionModel().clearSelection();
        sun_teach_3.setItems(add_tchr(str));

    }

    public void s4()
    {

        String str=null;
        str= (String) sun_sub_4.getSelectionModel().getSelectedItem();
        sun_teach_4.getSelectionModel().clearSelection();
        sun_teach_4.setItems(add_tchr(str));

    }

    public void s5()
    {

        String str=null;
        str= (String) sun_sub_5.getSelectionModel().getSelectedItem();
        sun_teach_5.getSelectionModel().clearSelection();
        sun_teach_5.setItems(add_tchr(str));

    }

    public void m1()
    {

        String str=null;
        str= (String)  mon_sub_1.getSelectionModel().getSelectedItem();
        mon_teach_1.getSelectionModel().clearSelection();
        mon_teach_1.setItems(add_tchr(str));

    }

    public void m2()
    {

        String str=null;
        str= (String) mon_sub_2.getSelectionModel().getSelectedItem();
        mon_teach_2.getSelectionModel().clearSelection();
        mon_teach_2.setItems(add_tchr(str));

    }

    public void m3()
    {

        String str=null;
        str= (String) mon_sub_3.getSelectionModel().getSelectedItem();
        mon_teach_3.getSelectionModel().clearSelection();
        mon_teach_3.setItems(add_tchr(str));

    }

    public void m4()
    {

        String str=null;
        str= (String) mon_sub_4.getSelectionModel().getSelectedItem();
        mon_teach_4.getSelectionModel().clearSelection();
        mon_teach_4.setItems(add_tchr(str));

    }

    public void m5()
    {

        String str=null;
        str= (String) mon_sub_5.getSelectionModel().getSelectedItem();
        mon_teach_5.getSelectionModel().clearSelection();
        mon_teach_5.setItems(add_tchr(str));

    }

    public void tu1()
    {

        String str=null;
        str= (String) tue_sub_1.getSelectionModel().getSelectedItem();
        tue_teach_1.getSelectionModel().clearSelection();
        tue_teach_1.setItems(add_tchr(str));

    }

    public void tu2()
    {

        String str=null;
        str= (String) tue_sub_2.getSelectionModel().getSelectedItem();
        tue_teach_2.getSelectionModel().clearSelection();
        tue_teach_2.setItems(add_tchr(str));

    }

    public void tu3()
    {

        String str=null;
        str= (String) tue_sub_3.getSelectionModel().getSelectedItem();
        tue_teach_3.getSelectionModel().clearSelection();
        tue_teach_3.setItems(add_tchr(str));

    }

    public void tu4()
    {

        String str=null;
        str= (String) tue_sub_4.getSelectionModel().getSelectedItem();
        tue_teach_4.getSelectionModel().clearSelection();
        tue_teach_4.setItems(add_tchr(str));

    }

    public void tu5()
    {

        String str=null;
        str= (String) tue_sub_5.getSelectionModel().getSelectedItem();
        tue_teach_5.getSelectionModel().clearSelection();
        tue_teach_5.setItems(add_tchr(str));

    }

    public void w1()
    {

        String str=null;
        str= (String)  wed_sub_1.getSelectionModel().getSelectedItem();
        wed_teach_1.getSelectionModel().clearSelection();
        wed_teach_1.setItems(add_tchr(str));

    }

    public void w2()
    {

        String str=null;
        str= (String) wed_sub_2.getSelectionModel().getSelectedItem();
        wed_teach_2.getSelectionModel().clearSelection();
        wed_teach_2.setItems(add_tchr(str));

    }

    public void w3()
    {

        String str=null;
        str= (String) wed_sub_3.getSelectionModel().getSelectedItem();
        wed_teach_3.getSelectionModel().clearSelection();
        wed_teach_3.setItems(add_tchr(str));

    }

    public void w4()
    {

        String str=null;
        str= (String) wed_sub_4.getSelectionModel().getSelectedItem();
        wed_teach_4.getSelectionModel().clearSelection();
        wed_teach_4.setItems(add_tchr(str));

    }

    public void w5()
    {

        String str=null;
        str= (String) wed_sub_5.getSelectionModel().getSelectedItem();
        wed_teach_5.getSelectionModel().clearSelection();
        wed_teach_5.setItems(add_tchr(str));

    }

    public void Combo_box()
    {
        List<String> list=new ArrayList<>();
        for(String data:Combo_sub)
        {
            list.add(data);
        }
        ObservableList data_list= FXCollections.observableArrayList(list);
        sun_sub_1.setItems(data_list);
        sun_sub_2.setItems(data_list);
        sun_sub_3.setItems(data_list);
        sun_sub_4.setItems(data_list);
        sun_sub_5.setItems(data_list);
        mon_sub_1.setItems(data_list);
        mon_sub_2.setItems(data_list);
        mon_sub_3.setItems(data_list);
        mon_sub_4.setItems(data_list);
        mon_sub_5.setItems(data_list);
        tue_sub_1.setItems(data_list);
        tue_sub_2.setItems(data_list);
        tue_sub_3.setItems(data_list);
        tue_sub_4.setItems(data_list);
        tue_sub_5.setItems(data_list);
        wed_sub_1.setItems(data_list);
        wed_sub_2.setItems(data_list);
        wed_sub_3.setItems(data_list);
        wed_sub_4.setItems(data_list);
        wed_sub_5.setItems(data_list);
        thur_sub_1.setItems(data_list);
        thur_sub_2.setItems(data_list);
        thur_sub_3.setItems(data_list);
        thur_sub_4.setItems(data_list);
        thur_sub_5.setItems(data_list);


        List<String> class_list=new ArrayList<>();
        for(String data:Combo_teacher)
        {
            class_list.add(data);
        }
        ObservableList data_list_teacher= FXCollections.observableArrayList(class_list);
        sun_teach_1.setItems(data_list_teacher);
        sun_teach_2.setItems(data_list_teacher);
        sun_teach_3.setItems(data_list_teacher);
        sun_teach_4.setItems(data_list_teacher);
        sun_teach_5.setItems(data_list_teacher);
        mon_teach_1.setItems(data_list_teacher);
        mon_teach_2.setItems(data_list_teacher);
        mon_teach_3.setItems(data_list_teacher);
        mon_teach_4.setItems(data_list_teacher);
        mon_teach_5.setItems(data_list_teacher);
        tue_teach_1.setItems(data_list_teacher);
        tue_teach_2.setItems(data_list_teacher);
        tue_teach_3.setItems(data_list_teacher);
        tue_teach_4.setItems(data_list_teacher);
        tue_teach_5.setItems(data_list_teacher);
        wed_teach_1.setItems(data_list_teacher);
        wed_teach_2.setItems(data_list_teacher);
        wed_teach_3.setItems(data_list_teacher);
        wed_teach_4.setItems(data_list_teacher);
        wed_teach_5.setItems(data_list_teacher);
        thur_teach_1.setItems(data_list_teacher);
        thur_teach_2.setItems(data_list_teacher);
        thur_teach_3.setItems(data_list_teacher);
        thur_teach_4.setItems(data_list_teacher);
        thur_teach_5.setItems(data_list_teacher);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Combo_box();

    }
}