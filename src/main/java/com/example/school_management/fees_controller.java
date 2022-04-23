package com.example.school_management;

import com.example.crud.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class fees_controller implements Initializable {

    @FXML
    private Label class_label;

    @FXML
    private AnchorPane crud_anchorpane;

    @FXML
    private Button crud_clear;

    @FXML
    private Button crud_clear1;

    @FXML
    private Button crud_clear11;

    @FXML
    private Button crud_clear111;

    @FXML
    private Button crud_clear2;

    @FXML
    private TextField crud_id;

    @FXML
    private TextField crud_id1;

    @FXML
    private Label file_path;

    @FXML
    private Label gender_label;

    @FXML
    private ImageView img_view;

    @FXML
    private AnchorPane left_crud_pane;

    @FXML
    private Label mob_label;

    @FXML
    private Label name_label;
    @FXML
    private Label fee_stat;

    @FXML
    void clear(ActionEvent event) {
        crud_id.setText("");
        name_label.setText("");
        gender_label.setText("");
        class_label.setText("");
        mob_label.setText("");
        img_view.setImage(null);
        file_path.setText("Label");
        fee_stat.setText("");
    }
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    @FXML
    void updt()
    {
        if(fee_stat.equals(""))
        {

        }
        else
        {
            String sql ="UPDATE student_data SET `fee`= '"+fee_stat.getText()+"' WHERE id = '"+crud_id.getText()+"'";
            try {
                connect= database.connectDB();
                if(crud_id.getText().isEmpty())
                {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("                                     Error!!!!!");
                    alert.setHeaderText("            ID field is empty.  ");
                    alert.setContentText("                             Please enter an Student id");
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

                }

            } catch (Exception e) {
                System.out.println("fee update crud error");
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


    }
    @FXML
    void srch()
    {
        String sql ="SELECT * FROM student_data WHERE `id` = '"+crud_id.getText()+"'";
        try {
            connect= database.connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();
            name_label.setText(result.getString("name"));
            class_label.setText(result.getString("class"));
            gender_label.setText(result.getString("gender"));
            mob_label.setText(result.getString("mobile"));
            fee_stat.setText(result.getString("fee"));
            String pic="file:"+ result.getString("picture");
            Image img= new Image(pic,110,110,false,true);

            img_view.setImage(img);
            file_path.setText(pic);

        }catch (Exception e) {
            System.out.println("fees database error");
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
    @FXML
    void un() { fee_stat.setText("Unknown"); }
    @FXML
    void cl() { fee_stat.setText("Collected");}
    @Override
    public void initialize(URL uurl, ResourceBundle resourse)
    {


    }

}
