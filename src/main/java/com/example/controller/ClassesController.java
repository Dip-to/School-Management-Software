package com.example.controller;

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

    private String[] Combo_sub={"Bangla","English","Math"};
    private String[] Combo_teacher={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};


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