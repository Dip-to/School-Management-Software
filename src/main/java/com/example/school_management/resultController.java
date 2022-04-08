package com.example.school_management;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class resultController implements Initializable {
    @FXML
    private TableColumn<?, ?> bangla12;

    @FXML
    private AnchorPane cls1_to_2_pane;

    @FXML
    private TableColumn<?, ?> english12;

    @FXML
    private TableColumn<?, ?> math12;

    @FXML
    private Button res_One_btn;

    @FXML
    private TableColumn<?, ?> res_cls12;

    @FXML
    private Button res_eight_btn;

    @FXML
    private Button res_five_btn;

    @FXML
    private Button res_four_btn;

    @FXML
    private TableColumn<?, ?> res_name12;

    @FXML
    private Button res_nine_btn;

    @FXML
    private TableColumn<?, ?> res_roll12;

    @FXML
    private Button res_seven_btn;

    @FXML
    private Button res_six_btn;

    @FXML
    private TableView<?> res_table_view12;

    @FXML
    private Button res_ten_btn;

    @FXML
    private Button res_three_btn;

    @FXML
    private Button res_two_btn;

    @FXML
    private Button result_back_button;

    @FXML
    private AnchorPane result_sub_pane1;

    @FXML
    private AnchorPane result_sub_pane2;

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

    public void res_one_btn_click()
    {
        result_sub_pane1.setVisible(false);
        result_sub_pane2.setVisible(false);
        cls1_to_2_pane.setVisible(true);
        result_back_button.setVisible(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}