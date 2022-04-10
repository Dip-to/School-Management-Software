package com.example.school_management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class resultController implements Initializable {
    @FXML
    private TableColumn<?, ?> SSC_bio;

    @FXML
    private TableColumn<?, ?> SSC_bng1;

    @FXML
    private TableColumn<?, ?> SSC_bng2;

    @FXML
    private TableColumn<?, ?> SSC_chem;

    @FXML
    private TableColumn<?, ?> SSC_eng1;

    @FXML
    private TableColumn<?, ?> SSC_eng2;

    @FXML
    private TableColumn<?, ?> SSC_hm;

    @FXML
    private TableColumn<?, ?> SSC_mth;

    @FXML
    private TableColumn<?, ?> SSC_name;

    @FXML
    private TableColumn<?, ?> SSC_phy;

    @FXML
    private TableColumn<?, ?> SSC_roll;

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
    private TableView<Primary_student> res_table_view12;

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
    private TableColumn<?, ?> sec_bgs;

    @FXML
    private TableColumn<?, ?> sec_bng1;

    @FXML
    private TableColumn<?, ?> sec_bng2;

    @FXML
    private TableColumn<?, ?> sec_eng1;

    @FXML
    private TableColumn<?, ?> sec_eng2;

    @FXML
    private TableColumn<?, ?> sec_ict;

    @FXML
    private TableColumn<?, ?> sec_mth;

    @FXML
    private TableColumn<?, ?> sec_name;

    @FXML
    private TableColumn<?, ?> sec_reli;

    @FXML
    private TableColumn<?, ?> sec_roll;

    @FXML
    private TableColumn<?, ?> sec_science;

    @FXML
    private AnchorPane secondary_pane;

    @FXML
    private TableView<?> secondary_tableview;

    @FXML
    private AnchorPane ssc_pane;

    @FXML
    private TableView<?> ssc_tableview;

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



    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    public ObservableList<Primary_student> datalist()
    {
        ObservableList<Primary_student> datalist = FXCollections.observableArrayList();


        String sql = "SELECT * FROM "+cc;

        try {
            connect= database.Result_connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while(result.next())
            {
                Primary_student student= new Primary_student(result.getInt("id"),result.getString("name"),result.getString("class"),result.getInt("bangla"),result.getInt("english"),result.getInt("math"));
                datalist.add(student);
            }

        }catch (Exception e) {
            System.out.println("result database error " + e);
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
        return datalist;
    }
    public void showData()
    {
        ObservableList<Primary_student> showlist = datalist();
        res_roll12.setCellValueFactory(new PropertyValueFactory<>("roll"));
        res_name12.setCellValueFactory(new PropertyValueFactory<>("name"));
        res_cls12.setCellValueFactory(new PropertyValueFactory<>("class_name"));
        bangla12.setCellValueFactory(new PropertyValueFactory<>("ban"));
        english12.setCellValueFactory(new PropertyValueFactory<>("en"));
        math12.setCellValueFactory(new PropertyValueFactory<>("mth"));
       res_table_view12.setItems(showlist);
    }
    public void getexcel(String c)
    {
        FileChooser open= new FileChooser();
        Stage stage=(Stage) result_sub_pane1.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null)
        {

            try {
                connect= database.Result_connectDB();
                String path=file.getAbsolutePath();
                String sql= "DELETE FROM "+c;
                prepare=connect.prepareStatement(sql);
                prepare.execute();
                prepare=null;
                String query="INSERT INTO "+c+" VALUES (?,?,?,?,?,?)";
                prepare = connect.prepareStatement(query);
                FileInputStream fule=new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fule);
                XSSFSheet sheet = wb.getSheetAt(0);
                Row row;
                for(int i=1; i<=sheet.getLastRowNum(); i++)
                {
                    row=  sheet.getRow(i);

                    prepare.setString(1, row.getCell(0).getStringCellValue());
                    prepare.setInt(2, (int) row.getCell(1).getNumericCellValue());
                    prepare.setString(3, row.getCell(2).getStringCellValue());
                    prepare.setInt(4, (int) row.getCell(3).getNumericCellValue());
                    prepare.setInt(5, (int) row.getCell(4).getNumericCellValue());
                    prepare.setInt(6, (int) row.getCell(5).getNumericCellValue());
                    prepare.execute();
                }
                prepare.close();
                connect.close();
                fule.close();
                wb.close();

            }catch (Exception e)
            {
                System.out.println(e);
            }
        }

    }
    public void resinit()
    {
        result_sub_pane1.setVisible(false);
        result_sub_pane2.setVisible(false);
        cls1_to_2_pane.setVisible(true);
        result_back_button.setVisible(true);
    }
    public String cc;
    public void res_one_btn_click()
    {
        cc="one";
        resinit();
        showData();
    }
    public void res_two_btn_click()
    {
        cc="two";
        resinit();
        showData();
    }
    public void res_three_btn_click()
    {
        cc="three";
        resinit();
        showData();
    }
    public void res_four_btn_click()
    {
        cc="four";
        resinit();
        showData();
    }
    public void res_five_btn_click()
    {
        cc="five";
        resinit();
        showData();
    }
    public void res_six_btn_click()
    {
        cc="six";
        resinit();
        showData();
    }
    public void res_seven_btn_click()
    {
        cc="seven";
        resinit();
        showData();
    }
    public void res_eight_btn_click()
    {
        cc="eight";
        resinit();
        showData();
    }
    public void res_nine_btn_click()
    {
        cc="nine";
        resinit();
        showData();
    }
    public void res_ten_btn_click()
    {
        cc="ten";
        resinit();
        showData();
    }

    public void res_back_btn_click()
    {
        result_sub_pane1.setVisible(true);
        result_sub_pane2.setVisible(true);
        cls1_to_2_pane.setVisible(false);
        result_back_button.setVisible(false);
    }

    public void b1() {cc="one"; getexcel("one");}
    public void b2() {cc="two"; getexcel("two");}
    public void b3() {cc="three"; getexcel("three");}
    public void b4() {cc="four"; getexcel("four");}
    public void b5() {cc="five"; getexcel("five");}
    public void b6() {cc="six"; getexcel("six");}
    public void b7() {cc="seven"; getexcel("seven");}
    public void b8() {cc="eight"; getexcel("eight");}
    public void b9() {cc="nine"; getexcel("nine");}
    public void b10() {cc="ten"; getexcel("ten");}
   // public void b5() {cc="five"; getexcel("five");}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}