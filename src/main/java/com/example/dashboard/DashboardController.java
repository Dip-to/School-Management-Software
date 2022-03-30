package com.example.dashboard;

import com.example.school_management.database;
import com.example.school_management.logincontroller;
import com.example.school_management.paneLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {


    @FXML
    private BorderPane dash_main;

    @FXML
    private Button login_img_button;

    @FXML
    private Button Student_count_button;

    @FXML
    private AnchorPane dashboard_pane;

    @FXML
    private Button about_icon;

    @FXML
    private Button classes_icon;

    @FXML
    private Button exit_button;

    @FXML
    private Button exit_icon;

    @FXML
    private ImageView exit_img;

    @FXML
    private Button home_button;

    @FXML
    private ImageView home_icon_img;

    @FXML
    private Button log_out_button;

    @FXML
    private Button logout_icon;

    @FXML
    private ImageView logout_img;

    @FXML
    private Button notice_icon;

    @FXML
    private Button result_icon;

    @FXML
    private Button student_icon;

    @FXML
    private Button stuff_count_button;

    @FXML
    private Button stuff_icon;

    @FXML
    private Button teacher_count_button;
    @FXML
    private AnchorPane dashboard_rightpane;

    @FXML
    private Circle image_circle;

    @FXML
    private Label username;

    @FXML
    private AnchorPane left_dash_pane;

    @FXML
    private Button teacher_icon;

    @FXML
    private ImageView imgg_view;


    public String login_img_path;
    public void exittt()
    {
        System.exit(0);
    }
    public void stud()  {
         try {
           // dashboard_pane.setVisible(false);
            dashboard_rightpane.setVisible(false);
            paneLoader pp= new paneLoader();
            Pane view=pp.getfxmlfile("Studcrud");
            dash_main.setCenter(view);
            dash_main.setVisible(true);
            dash_main.setDisable(false);
        }catch (Exception e)
        {
            System.out.println("stud crud fail");
        }
    }
    public void home_click()
    {
        dashboard_rightpane.setVisible(true);
        dash_main.setVisible(false);
        dash_main.setDisable(true);
    }
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    public void Img_Insert()
    {

        FileChooser open= new FileChooser();
        Stage stage=(Stage) left_dash_pane.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null)
        {

            String img_path=file.getAbsolutePath();
            img_path=img_path.replace("\\","\\\\\\\\");
            login_img_path=img_path;
            Image image= new Image(file.toURI().toString(),110,110,false,true);
            imgg_view.setImage(image);
            connect= database.connectDB();
            String sql="UPDATE login_data SET `image` = '"+img_path+"' WHERE username = '"+logincontroller.user+"'";
            System.out.println(img_path);
            try {
                statement=connect.createStatement();
                statement.executeUpdate(sql);
                login_img_button.setText("");


            }catch (Exception e)
            {
                System.out.println("login image database error");
            }

            System.out.println("bye");
        }
        else
        {
            System.out.println("login pic missing");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

          username.setText(logincontroller.user);
         // System.out.println(logincontroller.im_path);
          String tmp=logincontroller.im_path;
          if(tmp.equals("null"))
          {
              login_img_button.setText("Insert Image");
          }
          else
          {
              String pic="file:"+ tmp;
              Image img= new Image(pic,110,110,false,true);
              imgg_view.setImage(img);
              login_img_button.setText("");
          }


    }


}