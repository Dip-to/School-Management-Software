package com.example.school_management;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class noticeController implements Initializable {


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

    @FXML
    private Button back_button;

    public void button_1_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no1_pane.setVisible(true);
        back_button.setVisible(true);


    }

    public void button_2_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no2_pane.setVisible(true);
        back_button.setVisible(true);


    }

    public void button_3_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no3_pane.setVisible(true);
        back_button.setVisible(true);


    }

    public void button_4_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no4_pane.setVisible(true);
        back_button.setVisible(true);


    }

    public void button_5_click()
    {
        notice_pane1.setVisible(false);
        notice_pane1.setDisable(true);
        notice_pane2.setVisible(false);
        notice_pane2.setDisable(true);
        notice_no5_pane.setVisible(true);
        back_button.setVisible(true);


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}