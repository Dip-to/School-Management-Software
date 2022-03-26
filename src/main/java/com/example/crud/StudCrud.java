package com.example.crud;


import com.example.crud.Data;
import com.example.school_management.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class StudCrud implements Initializable {

    @FXML
    private AnchorPane left_crud_pane;

    @FXML
    private AnchorPane stud_crud;

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
    private ImageView img_view;

    @FXML
    private Label file_path;

    @FXML
    private TableView<Data> table_view;

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
    ///// database
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public ObservableList<Data> datalist()
    {
        ObservableList<Data> datalist = FXCollections.observableArrayList();
        String sql="SELECT * FROM student_data";
        connect= database.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();
            Data data;
            while(result.next())
            {
                data = new Data(result.getInt("id"),result.getString("name"),result.getString("class"),result.getString("gender"),result.getString("picture"));
                datalist.add(data);
            }
        }catch (Exception e) {
            System.out.println("student database error");
        }
        return datalist;
    }
    public void showData()
    {
        ObservableList<Data> showlist = datalist();
        id_table.setCellValueFactory(new PropertyValueFactory<>("crud_id"));
        name_table.setCellValueFactory(new PropertyValueFactory<>("curd_name"));
        class_table.setCellValueFactory(new PropertyValueFactory<>("curd_class"));
        Gender_table.setCellValueFactory(new PropertyValueFactory<>("curd_gender"));
        picture_table.setCellValueFactory(new PropertyValueFactory<>("curd_picture"));
        table_view.setItems(showlist);

    }
    public void ImgInsert()
    {
        FileChooser open= new FileChooser();
        Stage stage=(Stage) left_crud_pane.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null)
        {
            String img_path=file.getAbsolutePath();
            file_path.setText(img_path);
            Image image= new Image(file.toURI().toString(),110,110,false,true);
            img_view.setImage(image);
        }
        else
        {
            System.out.println("student pic missing");
        }
    }
    public void insert()
    {
        connect= database.connectDB();
        String sql="INSERT INTO student_data VALUES (?,?,?,?,?)";

        try {
                prepare=connect.prepareStatement(sql);
                prepare.setString(1,crud_id.getText());
                prepare.setString(2,crud_name.getText());
                prepare.setString(3, (String) crud_class.getSelectionModel().getSelectedItem());
                prepare.setString(4, (String) crud_gender.getSelectionModel().getSelectedItem());
                prepare.setString(5,file_path.getText());
                prepare.executeUpdate();
                showData();
        }catch (Exception e) {
            System.out.println("Student Insert error");
        }
    }

    @Override
    public void initialize(URL uurl, ResourceBundle resourse)
    {
        Combo_box();
        showData();

    }

}
