package com.example.school_management;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import java.util.ResourceBundle;

public class noticeController implements Initializable {

    @FXML
    private Button back_button;

    @FXML
    private Button button_1;

    @FXML
    private Button button_2;

    @FXML
    private Button button_3;

    @FXML
    private Button button_4;

    @FXML
    private Button button_5;

    @FXML
    private Label date_1;

    @FXML
    private Label date_2;

    @FXML
    private Label date_3;

    @FXML
    private Label date_4;

    @FXML
    private Label date_5;

    @FXML
    private ImageView im_view1;

    @FXML
    private ImageView im_view2;

    @FXML
    private ImageView im_view3;

    @FXML
    private ImageView im_view4;

    @FXML
    private ImageView im_view5;

    @FXML
    private Label no1;

    @FXML
    private Label no2;

    @FXML
    private Label no3;

    @FXML
    private Label no4;

    @FXML
    private Label no5;

    @FXML
    private AnchorPane notice_main;

    @FXML
    private AnchorPane notice_no1_pane;

    @FXML
    private AnchorPane notice_no2_pane;

    @FXML
    private AnchorPane notice_no3_pane;

    @FXML
    private AnchorPane notice_no4_pane;

    @FXML
    private AnchorPane notice_no5_pane;

    @FXML
    private AnchorPane notice_pane1;

    @FXML
    private AnchorPane notice_pane2;

    @FXML
    private Button update_1;

    @FXML
    private Button update_2;

    @FXML
    private Button update_3;

    @FXML
    private Button update_4;

    @FXML
    private Button update_5;


    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    public void notice_rend(String s)
    {
        database db= new database();
        String pp = db.notice_render(s);
        if(pp.equals("null"))
        {
            backbutton_click();
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("                                      ERROR!!!");
            alert.setHeaderText("       Notice Missing!!!!");
            alert.setContentText("                               Please add a notice.");
            alert.showAndWait();

        }
        else
        {

            Image img= new Image(pp,800,700,false,true);
            if(s.equals("1")) im_view1.setImage(img);
            else if(s.equals("2")) im_view2.setImage(img);
            else if(s.equals("3")) im_view3.setImage(img);
            else if(s.equals("4")) im_view4.setImage(img);
            else if(s.equals("5")) im_view5.setImage(img);
        }
    }
    public void button_1_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no1_pane.setVisible(true);
        back_button.setVisible(true);
        notice_rend("1");
    
    }
    public void button_2_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no2_pane.setVisible(true);
        back_button.setVisible(true);
        notice_rend("2");
    }

    public void button_3_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no3_pane.setVisible(true);
        back_button.setVisible(true);
        notice_rend("3");

    }

    public void button_4_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no4_pane.setVisible(true);
        back_button.setVisible(true);
        notice_rend("4");

    }

    public void button_5_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no5_pane.setVisible(true);
        back_button.setVisible(true);
        notice_rend("5");

    }

    public void backbutton_click()
    {
        back_button.setVisible(false);
        notice_pane1.setVisible(true);
        notice_pane1.setDisable(false);
        notice_pane2.setVisible(true);
        notice_pane2.setDisable(false);
        notice_no1_pane.setVisible(false);
        notice_no2_pane.setVisible(false);
        notice_no3_pane.setVisible(false);
        notice_no4_pane.setVisible(false);
        notice_no5_pane.setVisible(false);
    }
    public void up_backend(String s)
    {
        FileChooser open= new FileChooser();
        Stage stage=(Stage) notice_main.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null)
        {
            String img_path=file.getAbsolutePath();
            database db= new database();
            db.notice_update(img_path,s);
        }
    }
    public void up1()
    {
        up_backend("1");
    }
    public void up2()
    {
        up_backend("2");
    }
    public void up3()
    {
        up_backend("3");
    }
    public void up4()
    {
        up_backend("4");
    }
    public void up5()
    {
        up_backend("5");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}