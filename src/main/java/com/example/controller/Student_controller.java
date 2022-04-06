package com.example.controller;


import com.example.crud.Student;
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
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class Student_controller implements Initializable {

    @FXML
    private AnchorPane left_crud_pane;

    @FXML
    private AnchorPane stud_crud;

    @FXML
    private AnchorPane crud_anchorpane;

    @FXML
    private AnchorPane crud_class_select_pane;


    @FXML
    private TableColumn<Student, String> Gender_table;

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
    private AnchorPane stud_crid_mainpane;

    @FXML
    private TableView<Student> table_view;

    @FXML
    private TableColumn<Student, String> class_table;

    @FXML
    private TableColumn<Student, Integer> id_table;

    @FXML
    private TableColumn<Student, String> mobile_table;

    @FXML
    private TableColumn<Student, String> name_table;

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
        crud_mobile.setText("");

    }
    public void print_rep()
    {
        try
        {
            connect=database.connectDB();
            JasperDesign jdesign= JRXmlLoader.load("src/main/resources/com/example/school_management/report_jasper/stud_"+"all"+".jrxml");
            String clastitle="Class: "+ccc;
            if(ccc.equals("all"))
            {
                clastitle="Class: All";
            }
            else
            {
                JRDesignQuery jq= new JRDesignQuery();
                jq.setText("SELECT * FROM student_data WHERE `class` = '"+ccc+"'");
                jdesign.setQuery(jq);

            }
            String filepath="src/main/resources/com/example/school_management/report_jasper/stud_all.jrxml";
            Map<String,Object> para=new HashMap<String,Object>();
            para.put("class_name",clastitle);

            JasperReport jreport= JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint= JasperFillManager.fillReport(jreport,para,connect);
            JasperViewer viewer= new JasperViewer(jprint,false);
            viewer.setTitle("Report");
            viewer.show();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


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
            showData(ccc);
            clear();

        } catch (SQLException e) {
            System.out.println("delete error");
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

    public ObservableList<Student> datalist(String cls)
    {
        ObservableList<Student> datalist = FXCollections.observableArrayList();

        String sql;
        if(cls.equals("all")) sql ="SELECT * FROM student_data";
        else sql = "SELECT * FROM student_data WHERE `class` = '"+cls+"'";

        try {
            connect= database.connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();


            while(result.next())
            {
                Student student= new Student (result.getInt("id"),result.getString("name"),result.getString("class"),result.getString("gender"),result.getString("picture"),result.getString("mobile"));

                datalist.add(student);
            }

        }catch (Exception e) {
            System.out.println("student database error");
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
        return datalist;
    }
    public void showData(String clss)
    {
        ObservableList<Student> showlist = datalist(clss);
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

        String sql="INSERT INTO student_data VALUES (?,?,?,?,?,?)";

        try {
            connect= database.connectDB();
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
                prepare.execute();
                System.out.println("ok12");
                showData(ccc);
                clear();
            }


        }catch (Exception e) {
            System.out.println(e);
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
    public void selectData()
    {
        Student studnt = table_view.getSelectionModel().getSelectedItem();
        int no=table_view.getSelectionModel().getSelectedIndex();
        if((no-1)<-1)
        {
            return;
        }
        crud_id.setText(String.valueOf(studnt.getCrud_id()));
        crud_name.setText(String.valueOf(studnt.getCurd_name()));
      //  crud_gender.getSelectionModel().select(Integer.parseInt(data.getCurd_gender()));
        crud_gender.getSelectionModel().clearSelection();
     //   crud_class.getSelectionModel().select(Integer.parseInt(data.getCurd_class()));
        //crud_class.getSelectionModel().clearSelection();
        crud_class.getSelectionModel().clearSelection();
        String pic="file:"+ studnt.getCurd_picture();
        Image img= new Image(pic,110,110,false,true);
        img_view.setImage(img);

        String tmp= studnt.getCurd_picture();

        file_path.setText(tmp);
        crud_mobile.setText(String.valueOf(studnt.getCurd_mobile()));
    }
    public void update_Crud()
    {
        String tmp=file_path.getText();
        tmp=tmp.replace("\\","\\\\");
        String sql="UPDATE student_data SET `name`= '"+crud_name.getText()+ "', `class` = '"+crud_class.getSelectionModel().getSelectedItem()
                +"', `gender` = '"+crud_gender.getSelectionModel().getSelectedItem()+"', `picture` = '"+tmp+"' WHERE id = '"+crud_id.getText()+"'";
        try {
            connect= database.connectDB();
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
                showData(ccc);
                clear();
            }

        } catch (Exception e) {
            System.out.println("update crud error");
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

    //xtra
    public String ccc;
    public void click_but()
    {
        crud_class_select_pane.setVisible(false);
        crud_anchorpane.setVisible(true);
    }
    public void button_all()
    {
        click_but();
        ccc="all";
        showData(ccc);
    }
    public void button_one()
    {
        ccc="One";
        click_but();
        showData(ccc);
    }
    public void button_two()
    {
        ccc="Two";
        click_but();
        showData(ccc);
    }
    public void button_three()
    {
        ccc="Three";
        click_but();
        showData(ccc);
    }
    public void button_four()
    {
        click_but();
        ccc="Four";
        showData(ccc);
    }
    public void button_five()
    {
        ccc="Five";
        click_but();
        showData(ccc);
    }
    public void button_six()
    {
        ccc="Six";
        click_but();
        showData(ccc);
    }
    public void button_seven()
    {
        ccc="Seven";
        click_but();
        showData(ccc);
    }
    public void button_eight()
    {
        ccc="Eight";
        click_but();
        showData(ccc);
    }
    public void button_nine()
    {
        ccc="Nine";
        click_but();
        showData(ccc);
    }
    public void button_ten()
    {
        ccc="Ten";
        click_but();
        showData(ccc);
    }

    @Override
    public void initialize(URL uurl, ResourceBundle resourse)
    {
        Combo_box();


    }

}
