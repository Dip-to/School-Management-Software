package com.example.dashboard;

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

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {


    @FXML
    private BorderPane dash_main;

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
    private Button teacher_icon;

    @FXML
    private ImageView img_view;



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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


//           demo_imgview.set
//        image_circle.setStroke(Color.SEAGREEN);
//        //Image im=new Image();
//        image_circle.setFill(new ImagePattern(im));
//        image_circle.setEffect(new DropShadow(+25d,+0d,+2d,Color.DARKSEAGREEN));

    }


}