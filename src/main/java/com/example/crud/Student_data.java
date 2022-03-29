package com.example.crud;


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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Student_data implements Initializable {

    @FXML
    private AnchorPane left_crud_pane;

    @FXML
    private AnchorPane stud_crud;

    @FXML
    private TableColumn<People, String> Gender_table;

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
    private TextField crud_mobile;

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
    private TableView<People> table_view;

    @FXML
    private TableColumn<People, String> class_table;

    @FXML
    private TableColumn<People, Integer> id_table;

    @FXML
    private TableColumn<People, String> mobile_table;

    @FXML
    private TableColumn<People, String> name_table;

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
    public void clear()
    {
        crud_id.setText("");
        crud_name.setText("");
        crud_class.getSelectionModel().clearSelection();
        crud_gender.getSelectionModel().clearSelection();
        img_view.setImage(null);
        file_path.setText("Label");
    }
    public void delete()
    {
        String sql="DELETE from student_data WHERE `id` ='"+crud_id.getText()+"'";
        connect=database.connectDB();
        try
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("                                     Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("                     Are you sure you want to delete? ");

            Optional<ButtonType> buttontype= alert.showAndWait();
            if(buttontype.get()==ButtonType.OK)
            {
                statement=connect.createStatement();
                statement.executeUpdate(sql);
            }
            showData();
            clear();

        } catch (SQLException e) {
            System.out.println("delete error");
        }
    }

    public ObservableList<People> datalist()
    {
        ObservableList<People> datalist = FXCollections.observableArrayList();
        String sql="SELECT * FROM student_data";
        connect= database.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();
            People people;
            while(result.next())
            {
                people = new People(result.getInt("id"),result.getString("name"),result.getString("class"),result.getString("gender"),result.getString("picture"),result.getString("mobile"));
                datalist.add(people);
            }
        }catch (Exception e) {
            System.out.println("student database error");
        }
        return datalist;
    }
    public void showData()
    {
        ObservableList<People> showlist = datalist();
        id_table.setCellValueFactory(new PropertyValueFactory<>("crud_id"));
        name_table.setCellValueFactory(new PropertyValueFactory<>("curd_name"));
        class_table.setCellValueFactory(new PropertyValueFactory<>("curd_class"));
        Gender_table.setCellValueFactory(new PropertyValueFactory<>("curd_gender"));
        mobile_table.setCellValueFactory(new PropertyValueFactory<>("curd_mobile"));
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

            img_path=img_path.replace("\\","\\\\");
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
        String sql="INSERT INTO student_data VALUES (?,?,?,?,?,?)";

        try {
            if(crud_id.getText().isEmpty() | crud_name.getText().isEmpty() | crud_class.getSelectionModel().isEmpty() |
                crud_gender.getSelectionModel().isEmpty() | img_view.getImage()==null)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("                                     Error!!!!!");
                alert.setHeaderText("            Some fields are empty.  ");
                alert.setContentText("                             Please enter all blank fields. ");
                alert.showAndWait();
            }
            else
            {
                prepare=connect.prepareStatement(sql);
                prepare.setString(1,crud_id.getText());
                prepare.setString(2,crud_name.getText());
                prepare.setString(3, (String) crud_class.getSelectionModel().getSelectedItem());
                prepare.setString(4, (String) crud_gender.getSelectionModel().getSelectedItem());
                prepare.setString(5,file_path.getText());
                prepare.setString(6,crud_mobile.getText());
                prepare.executeUpdate();
                showData();
                clear();
            }

        }catch (Exception e) {
            System.out.println("Student Insert error");
        }
    }
    public void selectData()
    {
        People people = table_view.getSelectionModel().getSelectedItem();
        int no=table_view.getSelectionModel().getSelectedIndex();
        if((no-1)<-1)
        {
            return;
        }
        crud_id.setText(String.valueOf(people.getCrud_id()));
        crud_name.setText(String.valueOf(people.getCurd_name()));
      //  crud_gender.getSelectionModel().select(Integer.parseInt(data.getCurd_gender()));
        crud_gender.getSelectionModel().clearSelection();
     //   crud_class.getSelectionModel().select(Integer.parseInt(data.getCurd_class()));
        //crud_class.getSelectionModel().clearSelection();
        crud_class.getSelectionModel().clearSelection();
        String pic="file:"+ people.getCurd_picture();
        Image img= new Image(pic,110,110,false,true);
        img_view.setImage(img);

        String tmp= people.getCurd_picture();

        file_path.setText(tmp);
        crud_mobile.setText(String.valueOf(people.getCurd_mobile()));
    }
    public void update_Crud()
    {
        String tmp=file_path.getText();
        tmp=tmp.replace("\\","\\\\");
        String sql="UPDATE student_data SET `name`= '"+crud_name.getText()+ "', `class` = '"+crud_class.getSelectionModel().getSelectedItem()
                +"', `gender` = '"+crud_gender.getSelectionModel().getSelectedItem()+"', `picture` = '"+tmp+"' WHERE id = '"+crud_id.getText()+"'";
        try {
            if(crud_id.getText().isEmpty() | crud_name.getText().isEmpty() | crud_class.getSelectionModel().isEmpty() |
                    crud_gender.getSelectionModel().isEmpty() | img_view.getImage()==null)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("                                     Error!!!!!");
                alert.setHeaderText("            Some fields are empty.  ");
                alert.setContentText("                             Please enter all blank fields. ");
                alert.showAndWait();
            }
            else
            {
                statement=connect.createStatement();
                statement.executeUpdate(sql);
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("                                      Update Successfull!!!");
                alert.setHeaderText("       ");
                alert.setContentText("                             Successfully updated the data. ");
                alert.showAndWait();
                showData();
                clear();
            }

        } catch (Exception e) {
            System.out.println("update crud error");
        }
    }
    @Override
    public void initialize(URL uurl, ResourceBundle resourse)
    {
        Combo_box();
        showData();

    }

}
