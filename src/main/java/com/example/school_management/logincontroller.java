package com.example.school_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class logincontroller implements Initializable {

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
    private Label db_stat;

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

    @FXML
    private AnchorPane base_pane;
    ////////
    private Pane sz;
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
            sign_employeeid.setText("");
            sign_username1.setText("");
            sign_pass1.setText("");
            sign_pass2.setText("");
        }
        else if(e.getSource()==alrdyhaveacc)
        {
            login_page.setVisible(true);
            signup_page.setVisible(false);
            login_pass.setText("");
            login_username.setText("");

        }
        else if(e.getSource()==Forgotpass)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("                                      Forgot Password!!!");
            alert.setHeaderText("        Please try to enter correct credentials.");
            alert.setContentText("          Or contact your system admin for a new password.");
            alert.showAndWait();
        }
       /* else if(e.getSource()==login_button)
        {
            login_page.setVisible(false);
            paneLoader obj=new paneLoader();

            Pane sz = obj.getfxmlfile("crud");

            mainpage.setCenter(sz);
            mainpage.setVisible(true);

        }*/
    }
    //database tools
    public static String user;
    public static String im_path;
    public static Integer user_id;
    private Connection connect;
    private Statement statement;
    private ResultSet resultset;
    private PreparedStatement prepare;
    public void login() throws ClassNotFoundException
    {
        connect=database.connectDB();

        String sql="SELECT * FROM login_data WHERE username = ? and password = ?" ;
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setString(1 , login_username.getText());
            prepare.setString(2 , login_pass.getText());
            String tmp_username= login_username.getText();

            resultset=prepare.executeQuery();
            //System.out.println("login error12");
            if(resultset.next())
            {
                //login done
                user=tmp_username;
                login_page.setVisible(false);
                paneLoader obj=new paneLoader();
                sz = obj.getfxmlfile("dashboard");
                mainpage.setCenter(sz);
                mainpage.setVisible(true);
                mainpage.setDisable(false);
               /// System.out.println("login error12");
            }
            else
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("                                      Login ERROR!!!");
                alert.setHeaderText("        Wrong Username or Password");
                alert.setContentText("                               Please try again.");
                alert.showAndWait();
            }

        }catch (Exception e)
        {
            System.out.println("login error in database");
        }
    }
    public void signUp()
    {
        connect=database.connectDB();
        String sql="INSERT INTO login_data (username , password , employee_id , image) VALUES (? , ? , ? , ?)";
        try{

            String p1=sign_pass1.getText();
            String p2=sign_pass2.getText();
            String usernm=sign_username1.getText();
            String employeid=sign_employeeid.getText();
            if(usernm.isEmpty())
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("                                      SignUp unsuccessfull!!!");
                alert.setHeaderText("       Username missing!!!!");
                alert.setContentText("                               Please enter an username.");
                alert.showAndWait();
            }
            else if(employeid.isEmpty())
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("                                      SignUp unsuccessfull!!!");
                alert.setHeaderText("       Employee ID number missing!!!!");
                alert.setContentText("                               Please enter an Employee ID number.");
                alert.showAndWait();
            }
            else if(p1.equals(p2))
            {
                prepare= connect.prepareStatement(sql);

                prepare.setString(1,sign_username1.getText());
                prepare.setString(2,sign_pass1.getText());
                prepare.setString(3,sign_employeeid.getText());
                prepare.setString(4,"null");
                prepare.execute();

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("                                      SignUp Successfull!!!");
                alert.setHeaderText("       Congratulation.!!!!");
                alert.setContentText("                              Your account is created.");
                alert.showAndWait();
                sign_employeeid.setText("");
                sign_username1.setText("");
                sign_pass1.setText("");
                sign_pass2.setText("");

           }
           else if(p1!=p2)
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("                                      SignUp unsuccessfull!!!");
                alert.setHeaderText("       Password didn't match!!!!");
                alert.setContentText("                               Please try again.");
                alert.showAndWait();
            }
        }catch(Exception e) {
            System.out.println("signup database error");
            e.printStackTrace();
        }

    }


    public void initialize(URL url, ResourceBundle rb)
    {
        connect=database.connectDB();
        if(connect==null)
        {
            db_stat.setText("Not Connected");
            db_stat.setTextFill(Color.RED);
        }
        else db_stat.setTextFill(Color.GREEN);
    }

}
