package com.example.crud;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudCrud implements Initializable {


    @FXML
    private TableColumn<Data, String> Gender_table;

    @FXML
    private Button crud_clear;

    @FXML
    private Button crud_delete;

    @FXML
    private ComboBox<?> crud_gender;

    @FXML
    private ComboBox<?> crud_class;

    @FXML
    private TextField crud_id;

    @FXML
    private Button crud_insert;

    @FXML
    private Button crud_insert_img;

    @FXML
    private Button crud_print;

    @FXML
    private TextField crud_name;

    @FXML
    private Button crud_update;

    @FXML
    private TableColumn<Data, String> class_table;

    @FXML
    private TableColumn<Data, Integer> id_table;

    @FXML
    private TableColumn<Data, String> picture_table;

    @FXML
    private TableColumn<Data, String> name_table;

    private String[] Combo_gender={"Male","Female","Others"};
    private String[] Combo_class={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};


    public void Combo_box()
    {
        List<String> list=new ArrayList<>();
        for(String data:Combo_gender)
        {
            list.add(data);
        }
        ObservableList data_list= FXCollections.observableArrayList(list);
        crud_gender.setItems(data_list);

        List<String> class_list=new ArrayList<>();
        for(String data:Combo_class)
        {
            class_list.add(data);
        }
        ObservableList data_list_class= FXCollections.observableArrayList(class_list);
        crud_class.setItems(data_list_class);
    }


//    public void Combo_box()
//    {
//        List<String> class_list=new ArrayList<>();
//        for(String data:Combo_class)
//        {
//            class_list.add(data);
//        }
//        ObservableList data_list= FXCollections.observableArrayList(class_list);
//        crud_class.setItems(data_list);
//    }


    public  void text_field_design(){
        if(crud_id.isFocused()){
            crud_id.setStyle("-fx-border-width:2px;-fx-background-color: #fff");
            crud_name.setStyle("-fx-border-width:1px;-fx-background-color: transparent");
            crud_class.setStyle("-fx-border-width:1px;-fx-background-color:  transparent");
            crud_gender.setStyle("-fx-border-width:1px;-fx-background-color:  transparent");
        }

        else if(crud_name.isFocused()){
            crud_id.setStyle("-fx-border-width:1px;-fx-background-color:transparent");
            crud_name.setStyle("-fx-border-width:2px;-fx-background-color: #fff");
            crud_class.setStyle("-fx-border-width:1px;-fx-background-color:  transparent");
            crud_gender.setStyle("-fx-border-width:1px;-fx-background-color:  transparent");
        }

        else if(crud_class.isFocused()){
            crud_id.setStyle("-fx-border-width:1px;-fx-background-color:transparent");
            crud_name.setStyle("-fx-border-width:1px;-fx-background-color:  transparent");
            crud_class.setStyle("-fx-border-width:2px;-fx-background-color: #fff");
            crud_gender.setStyle("-fx-border-width:1px;-fx-background-color:  transparent");
        }
        else if(crud_gender.isFocused()){
            crud_id.setStyle("-fx-border-width:1px;-fx-background-color:transparent");
            crud_name.setStyle("-fx-border-width:1px;-fx-background-color:  transparent");
            crud_class.setStyle("-fx-border-width:1px;-fx-background-color:  transparent");
            crud_gender.setStyle("-fx-border-width:2px;-fx-background-color: #fff");
        }
    }

    @Override
    public void initialize(URL uurl, ResourceBundle resourse)
    {
        Combo_box();
    }

}