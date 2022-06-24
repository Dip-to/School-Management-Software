package com.example.controller;

import com.example.school_management.database;
import com.example.school_management.paneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class logincontroller implements Initializable
{
    @FXML
    private Label stud_cnt;

    @FXML
    private Button add_acc;

    @FXML
    private ImageView add_acc_pic;

    @FXML
    private Hyperlink Forgotpass;

    @FXML
    private Button Student_count_button;

    @FXML
    private Button about_icon;

    @FXML
    private Hyperlink alrdyhaveacc;

    @FXML
    private AnchorPane base_pane;

    @FXML
    private CheckBox chck_box;

    @FXML
    private Button classes_icon;

    @FXML
    private Button close_button;

    @FXML
    private Button close_button1;

    @FXML
    private Hyperlink create_acc;

    @FXML
    private BorderPane dash_main;

    @FXML
    private AnchorPane dash_main_anchorpane;

    @FXML
    private AnchorPane dashboard_rightpane;

    @FXML
    private Separator dashboard_separator;

    @FXML
    private Label db_stat;

    @FXML
    private ImageView demo_imgview;

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
    private ImageView imgg_view;

    @FXML
    private AnchorPane left_dash_pane;

    @FXML
    private Button log_out_button;

    @FXML
    private Button login_button;

    @FXML
    private Button login_img_button;

    @FXML
    private AnchorPane login_page;

    @FXML
    private PasswordField login_pass;

    @FXML
    private TextField login_username;

    @FXML
    private Button logout_icon;

    @FXML
    private ImageView logout_img;

    @FXML
    private Button notice_icon;

    @FXML
    private Button result_icon;

    @FXML
    private TextField show_pass;

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

    @FXML
    private Button student_icon;

    @FXML
    private Button stuff_count_button;

    @FXML
    private Button stuff_icon;

    @FXML
    private Button teacher_count_button;

    @FXML
    private Button teacher_icon;

    @FXML
    private Label username;
    @FXML
    private Label tchr_cnt;
    @FXML
    private Label staff_cnt;



    ////dash
    public String login_img_path;
    public void add_ACC()
    {
        dashboard_rightpane.setVisible(false);
        signup_page.setVisible(true);
    }
    public void dash_init()
    {
        username.setText(user);
        // System.out.p rintln(im_path);
        String tmp=im_path;
        if(tmp.equals("null"))
        {
            imgg_view.imageProperty().set(null);
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
    public void rslt()  {
        try {
            // dashboard_pane.setVisible(false);
            dashboard_rightpane.setVisible(false);
            paneLoader pp= new paneLoader();
            Pane view=pp.getfxmlfile("result");
            dash_main.setCenter(view);
            dash_main.setVisible(true);
            dash_main.setDisable(false);
        }catch (Exception e)
        {
            System.out.println("result fail");
        }
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
    public void tchr()  {
        try {
            // dashboard_pane.setVisible(false);
            dashboard_rightpane.setVisible(false);
            paneLoader pp= new paneLoader();
            Pane view=pp.getfxmlfile("Teachercrud");

            dash_main.setCenter(view);
            dash_main.setVisible(true);
            dash_main.setDisable(false);
        }catch (Exception e)
        {
            System.out.println("stud crud fail");
        }
    }
    public void staff()  {
        try {
            // dashboard_pane.setVisible(false);
            dashboard_rightpane.setVisible(false);
            paneLoader pp= new paneLoader();
            Pane view=pp.getfxmlfile("Staffcrud");
            dash_main.setCenter(view);
            dash_main.setVisible(true);
            dash_main.setDisable(false);
        }catch (Exception e)
        {
            System.out.println("staff crud fail");
        }
    }
    public void notice()
    {
        try {
            // dashboard_pane.setVisible(false);
            dashboard_rightpane.setVisible(false);
            paneLoader pp= new paneLoader();
            Pane view=pp.getfxmlfile("notice");
            dash_main.setCenter(view);
            dash_main.setVisible(true);
            dash_main.setDisable(false);
        }catch (Exception e)
        {
            System.out.println("notice fail");
        }
    }
    public void class_routine()
    {
        try {
            // dashboard_pane.setVisible(false);
            dashboard_rightpane.setVisible(false);
            paneLoader pp= new paneLoader();
            Pane view=pp.getfxmlfile("classes");
            dash_main.setCenter(view);
            dash_main.setVisible(true);
            dash_main.setDisable(false);
        }catch (Exception e)
        {
            System.out.println("notice fail");
        }
    }
    public void home_click()
    {
        dashboard_rightpane.setVisible(true);
        signup_page.setVisible(false);
        dash_main.setVisible(false);
        dash_main.setDisable(true);
        cnt();
        dash_init();

    }
    public void fee() throws IOException {
        dashboard_rightpane.setVisible(false);
        paneLoader pp= new paneLoader();
        Pane view=pp.getfxmlfile("fees");
        dash_main.setCenter(view);
        dash_main.setVisible(true);
        dash_main.setDisable(false);


    }
    public void about() throws IOException {
        dashboard_rightpane.setVisible(false);
        paneLoader pp= new paneLoader();
        Pane view=pp.getfxmlfile("about");
        dash_main.setCenter(view);
        dash_main.setVisible(true);
        dash_main.setDisable(false);


    }


    public void log_out_click()
    {
        im_path="null";
        dash_init();
        dashboard_rightpane.setVisible(true);
        signup_page.setVisible(false);
        dash_main.setVisible(false);
        dash_main.setDisable(true);
        dash_main_anchorpane.setVisible(false);
        login_pass.setText("");
        login_username.setText("");
        chck_box.setSelected(false);
        show_pass.setVisible(false);
        login_pass.setVisible(true);
        login_page.setVisible(true);

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
            im_path=img_path;
            Image image= new Image(file.toURI().toString(),110,110,false,true);
            imgg_view.setImage(image);
            connect= database.connectDB();
            String sql="UPDATE login_data SET `image` = '"+img_path+"' WHERE username = '"+logincontroller.user+"'";
            // System.out.println(img_path);
            try {
                statement=connect.createStatement();
                statement.executeUpdate(sql);
                login_img_button.setText("");

            }catch (Exception e)
            {
                System.out.println("login image database error");
            }
            finally {
                try {
                    connect.close();
                    result.close();
                    prepare.close();
                    statement.close();

                }catch (Exception e)
                {

                }
            }

            // System.out.println("bye");
        }
        else
        {
            System.out.println("login pic missing");
        }
    }

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
    public void show_pass_click(ActionEvent e)
    {
        if(chck_box.isSelected())
        {
            show_pass.setText(login_pass.getText());
            show_pass.setVisible(true);
            login_pass.setVisible(false);
            return;
        }
        login_pass.setText(show_pass.getText());
        login_pass.setVisible(true);
        show_pass.setVisible(false);


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
            chck_box.setSelected(false);
            show_pass.setVisible(false);
            login_pass.setVisible(true);

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
    //private Connection connect;
    //private Statement statement;
    private ResultSet resultset;
   // private PreparedStatement prepare;
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
                if(user.equals("admin@sms"))
                {
                    add_acc.setVisible(true);
                    add_acc_pic.setVisible(true);
                }
                else
                {
                    add_acc.setVisible(false);
                    add_acc_pic.setVisible(false);

                }
                im_path=resultset.getString("image");
                login_page.setVisible(false);
                dash_main_anchorpane.setVisible(true);
                cnt();
                dash_init();

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
        finally
        {
            try
            {
                connect.close();
                resultset.close();
                prepare.close();
                statement.close();

            }catch (Exception e)
            {

            }
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
        finally
        {
            try
            {
                connect.close();
                resultset.close();
                prepare.close();
                statement.close();

            }catch (Exception e)
            {

            }
        }

    }

    public String cdat(String ss)
    {
        int s=0;
        String sql = "SELECT * FROM "+ ss;
        try {
            connect= database.connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();
            while(result.next())
            {
                s++;
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


            }catch (Exception e)
            {
                System.out.println("hi"+e);
            }
        }
        String pp= String.valueOf(s);
        return pp;
    }
    public void cnt()
    {
        tchr_cnt.setText(cdat("student_data"));
        stud_cnt.setText(cdat("teacher_data"));
        staff_cnt.setText(cdat("staff_data"));
    }



    public void initialize(URL url, ResourceBundle rb)
    {


    }

}
