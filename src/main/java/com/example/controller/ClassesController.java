package com.example.controller;

import com.example.school_management.database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassesController implements Initializable {
    @FXML
    private Button One_btn;

    @FXML
    private Button class_back_button;

    @FXML
    private AnchorPane class_sub_pane1;

    @FXML
    private AnchorPane class_sub_pane2;

    @FXML
    private AnchorPane cls_one_pane;

    @FXML
    private Button eight_btn;

    @FXML
    private Button five_btn;

    @FXML
    private Button four_btn;

    @FXML
    private Button nine_btn;

    @FXML
    private ImageView one_routine_imgview;

    @FXML
    private Button seven_btn;

    @FXML
    private AnchorPane class_main;

    @FXML
    private Button six_btn;

    @FXML
    private Button ten_btn;

    @FXML
    private Button three_btn;

    @FXML
    private Button two_btn;

    @FXML
    private Button update_1;

    @FXML
    private Button update_10;

    @FXML
    private Button update_2;

    @FXML
    private Button update_3;

    @FXML
    private Button update_4;

    @FXML
    private Button update_5;

    @FXML
    private Button update_6;

    @FXML
    private Button update_7;

    @FXML
    private Button update_8;

    @FXML
    private Button update_9;


    public void one_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("1");

    }
    public void two_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("2");

    }

    public void three_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("3");

    }
    public void four_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("4");

    }

    public void five_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("5");

    }
    public void six_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("6");

    }

    public void seven_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("7");

    }
    public void eight_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("8");

    }

    public void nine_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("9");

    }
    public void ten_btn_click()
    {
        class_sub_pane1.setVisible(false);
        class_sub_pane1.setDisable(true);
        class_sub_pane2.setVisible(false);
        class_sub_pane2.setDisable(true);
        cls_one_pane.setVisible(true);
        class_back_button.setVisible(true);
        render_bakcend("10");

    }


    public void render_bakcend(String s)
    {
        database db= new database();
        String pp = db.classroom_render(s);
        if(pp.equals("null"))
        {
            class_backbutton_click();
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("                                      ERROR!!!");
            alert.setHeaderText("       Routine Missing!!!!");
            alert.setContentText("                               Please add a routine.");
            alert.showAndWait();
        }
        else
        {
            Image img= new Image(pp,800,700,false,true);
            one_routine_imgview.setImage(img);
        }
    }

    public void class_backbutton_click()
    {
        class_back_button.setVisible(false);
        class_sub_pane1.setVisible(true);
        class_sub_pane1.setDisable(false);
        class_sub_pane2.setVisible(true);
        class_sub_pane2.setDisable(false);
        cls_one_pane.setVisible(false);
        one_routine_imgview.setImage(null);

    }
    public void update_backend(int x)
    {
        FileChooser open= new FileChooser();
        Stage stage=(Stage) class_main.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null)
        {
            String img_path=file.getAbsolutePath();
            database db=  new database();
            db.classroom(img_path,x);
        }
    }

    public void bt1()
    {
        update_backend(1);
    }
    public void bt2()
    {
        update_backend(2);
    }

    public void bt3()
    {
        update_backend(3);
    }
    public void bt4()
    {
        update_backend(4);
    }

    public void bt5()
    {
        update_backend(5);
    }
    public void bt6()
    {
        update_backend(6);
    }

    public void bt7()
    {
        update_backend(7);
    }
    public void bt8()
    {
        update_backend(8);
    }

    public void bt9()
    {
        update_backend(9);
    }
    public void bt10()
    {
        update_backend(10);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        one_routine_imgview.setImage(null);
    }
}