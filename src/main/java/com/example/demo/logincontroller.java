package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class logincontroller {

    @FXML
    private Hyperlink Forgotpass;

    @FXML
    private Hyperlink alrdyhaveacc;

    @FXML
    private Button close_button;

    @FXML
    private Button close_button1;

    @FXML
    private Hyperlink create_acc;

    @FXML
    private Button login_button;

    @FXML
    private AnchorPane login_page;

    @FXML
    private PasswordField login_pass;

    @FXML
    private TextField login_username;

    @FXML
    private BorderPane mainpage;

    @FXML
    private TextField sign_employeeid;

    @FXML
    private PasswordField sign_pass1;

    @FXML
    private PasswordField sign_pass2;

    @FXML
    private TextField sign_username1;

    @FXML
    private Button signup_button1;

    @FXML
    private AnchorPane signup_page;
    ////////
    public void exittt()
    {
        System.exit(0);
    }

    public void textfielddesign()
    {
        if(login_username.isFocused())
        {
            login_username.setStyle("-fx-background-color: #fff;"+"-fx-border-width: 2px");
            login_pass.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
        }
        else if(login_pass.isFocused())
        {
            login_username.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            login_pass.setStyle("-fx-background-color: #fff;"+"-fx-border-width: 2px");
        }
    }
    public void signup_textfielddesign()
    {
        if(sign_username1.isFocused())
        {
            sign_username1.setStyle("-fx-background-color: #fff;"+"-fx-border-width: 2px");
            sign_employeeid.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            sign_pass1.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            sign_pass2.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
        }
        else if(sign_employeeid.isFocused())
        {
            sign_employeeid.setStyle("-fx-background-color: #fff;"+"-fx-border-width: 2px");
            sign_username1.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            sign_pass1.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            sign_pass2.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
        }
        else if(sign_pass1.isFocused())
        {
            sign_pass1.setStyle("-fx-background-color: #fff;"+"-fx-border-width: 2px");
            sign_username1.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            sign_employeeid.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            sign_pass2.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
        }
        else if(sign_pass2.isFocused())
        {
            sign_pass2.setStyle("-fx-background-color: #fff;"+"-fx-border-width: 2px");
            sign_username1.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            sign_employeeid.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
            sign_pass1.setStyle("-fx-background-color: transparent;"+"-fx-border-width: 1px");
        }

    }

    public void changePage(ActionEvent e) throws IOException {
        if(e.getSource()==create_acc)
        {
            signup_page.setVisible(true);
            login_page.setVisible(false);
        }
        else if(e.getSource()==alrdyhaveacc)
        {
            login_page.setVisible(true);
            signup_page.setVisible(false);
        }
        else if(e.getSource()==login_button)
        {
            login_page.setVisible(false);
            paneLoader obj=new paneLoader();

            Pane sz = obj.getfxmlfile("crud");

            mainpage.setCenter(sz);
            mainpage.setVisible(true);

        }
    }
    public void initialize(URL url, ResourceBundle rb)
    {

    }

}
