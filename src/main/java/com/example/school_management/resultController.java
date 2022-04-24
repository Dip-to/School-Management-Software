package com.example.school_management;

import com.example.subject.Primary_subject;
import com.example.subject.HighSchool_subject;
import com.example.subject.Secondary_subject;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
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
import java.util.HashMap;
import java.util.Map;
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
    private TableColumn<?, ?> SSC_cls;

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
    private Button com_btn;

    @FXML
    private Button com_excel;

    @FXML
    private AnchorPane dcsn;

    @FXML
    private TableColumn<?, ?> english12;

    @FXML
    private TableColumn<?, ?> math12;

    @FXML
    private Button print_btn;

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
    private TableView<Primary_subject> res_table_view12;

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
    private Button sci_excel;

    @FXML
    private TableColumn<?, ?> sec_bgs;

    @FXML
    private TableColumn<?, ?> sec_bng1;

    @FXML
    private TableColumn<?, ?> sec_bng2;

    @FXML
    private TableColumn<?, ?> sec_cls;

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
    private TableView<HighSchool_subject> secondary_tableview;

    @FXML
    private Button sicene_btn;

    @FXML
    private AnchorPane ssc_pane;

    @FXML
    private TableView<Secondary_subject> ssc_tableview;

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


    public String ss;
    public void prim_print_rep()
    {

        try
        {
            String ct=cc;
            connect=database.Result_connectDB();
            JasperDesign jdesign=null;
            if(class_cat(cc)==1) jdesign= JRXmlLoader.load("src/main/resources/com/example/school_management/report_jasper/primary.jrxml");
            else if(class_cat(cc)==2) jdesign= JRXmlLoader.load("src/main/resources/com/example/school_management/report_jasper/high.jrxml");
            else if(class_cat(cc)==3)
            {
                jdesign = JRXmlLoader.load("src/main/resources/com/example/school_management/report_jasper/Sci.jrxml");
                if(ss.equals("com"))
                {
                    jdesign=null;
                    if(cc.equals("nine_com")) ct="Nine";
                    else ct="Ten";
                    jdesign= JRXmlLoader.load("src/main/resources/com/example/school_management/report_jasper/Com.jrxml");
                }
            }
            String clastitle="Class: "+ct;
                JRDesignQuery jq= new JRDesignQuery();
                jq.setText("SELECT * FROM "+cc);
                if(ss.equals("com") && (cc.equals("nine") || cc.equals("ten")))
                {
                    jq.setText("SELECT * FROM "+cc+"_com");
                }
                jdesign.setQuery(jq);
            String filepath="src/main/resources/com/example/school_management/report_jasper/stud_all.jrxml";
            Map<String,Object> para=new HashMap<String,Object>();
            para.put("parapara",clastitle);


            JasperReport jreport= JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint= JasperFillManager.fillReport(jreport,para,connect);
            JasperViewer viewer= new JasperViewer(jprint,false);
            viewer.setTitle("Report");
            viewer.show();
        }
        catch (Exception e)
        {
            System.out.println(e);
            //System.out.println(e);
        }


    }
    public int class_cat(String m)
    {
        if(m.equals("one") || m.equals("two") || m.equals("three") || m.equals("four") || m.equals("five") ) return 1;
        else if(m.equals("six") || m.equals("seven") || m.equals("eight")) return 2;
        else if(m.equals("nine") || m.equals("ten") ||m.equals("nine_com") || m.equals("ten_com") ) return 3;
        else return 4;
    }
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    public ObservableList<Primary_subject> datalist()
    {
        ObservableList<Primary_subject> datalist = FXCollections.observableArrayList();


        String sql = "SELECT * FROM "+cc;

        try {
            connect= database.Result_connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while(result.next())
            {
                Primary_subject student= new Primary_subject(result.getInt("id"),result.getString("name"),result.getString("class"),result.getInt("bangla"),result.getInt("english"),result.getInt("math"));
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
    public ObservableList<HighSchool_subject> high_datalist()
    {
        ObservableList<HighSchool_subject> datalist = FXCollections.observableArrayList();


        String sql = "SELECT * FROM "+cc;

        try {
            connect= database.Result_connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while(result.next())
            {
                HighSchool_subject student= new HighSchool_subject(result.getInt("roll"),result.getString("name"),result.getString("class"),result.getInt("bng_1"),result.getInt("bng_2"),result.getInt("eng_1"),result.getInt("eng_2"),
                        result.getInt("math"),result.getInt("science"),result.getInt("religion"),result.getInt("bgs"),result.getInt("ict") );
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
    public ObservableList<Secondary_subject> sec_datalist(String oo)
    {
        ObservableList<Secondary_subject> datalist = FXCollections.observableArrayList();


        String sql = "SELECT * FROM "+cc+oo;

        try {
            connect= database.Result_connectDB();
            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while(result.next())
            {
                Secondary_subject student= new Secondary_subject(result.getInt("roll"),result.getString("name"),result.getString("class"),result.getInt("bng_1"),result.getInt("bng_2"),result.getInt("eng_1"),result.getInt("eng_2"),
                        result.getInt("math"),result.getInt("phy"),result.getInt("chm"),result.getInt("h_math"),result.getInt("bio") );
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
    public void showData(String oo)
    {
        if(class_cat(cc)==1)
        {
            ObservableList<Primary_subject> showlist = datalist();
            res_roll12.setCellValueFactory(new PropertyValueFactory<>("roll"));
            res_name12.setCellValueFactory(new PropertyValueFactory<>("name"));
            res_cls12.setCellValueFactory(new PropertyValueFactory<>("class_name"));
            bangla12.setCellValueFactory(new PropertyValueFactory<>("ban"));
            english12.setCellValueFactory(new PropertyValueFactory<>("en"));
            math12.setCellValueFactory(new PropertyValueFactory<>("mth"));
            res_table_view12.setItems(showlist);
        }
        else if(class_cat(cc)==2)
        {
            ObservableList<HighSchool_subject> showlist = high_datalist();
            sec_roll.setCellValueFactory(new PropertyValueFactory<>("roll"));
            sec_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            sec_cls.setCellValueFactory(new PropertyValueFactory<>("class_name"));
            sec_bng1.setCellValueFactory(new PropertyValueFactory<>("ban"));
            sec_bng2.setCellValueFactory(new PropertyValueFactory<>("ban2"));
            sec_eng1.setCellValueFactory(new PropertyValueFactory<>("en"));
            sec_eng2.setCellValueFactory(new PropertyValueFactory<>("en2"));
            sec_mth.setCellValueFactory(new PropertyValueFactory<>("mth"));
            sec_science.setCellValueFactory(new PropertyValueFactory<>("science"));
            sec_reli.setCellValueFactory(new PropertyValueFactory<>("religion"));
            sec_bgs.setCellValueFactory(new PropertyValueFactory<>("bgs"));
            sec_ict.setCellValueFactory(new PropertyValueFactory<>("ict"));
            secondary_tableview.setItems(showlist);
        }
        else if(class_cat(cc)==3)
        {
            ObservableList<Secondary_subject> showlist = sec_datalist(oo);
            SSC_roll.setCellValueFactory(new PropertyValueFactory<>("roll"));
            SSC_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            SSC_cls.setCellValueFactory(new PropertyValueFactory<>("class_name"));
            SSC_bng1.setCellValueFactory(new PropertyValueFactory<>("ban"));
            SSC_bng2.setCellValueFactory(new PropertyValueFactory<>("ban2"));
            SSC_eng1.setCellValueFactory(new PropertyValueFactory<>("en"));
            SSC_eng2.setCellValueFactory(new PropertyValueFactory<>("en2"));
            SSC_mth.setCellValueFactory(new PropertyValueFactory<>("mth"));
            SSC_phy.setCellValueFactory(new PropertyValueFactory<>("phy"));
            SSC_chem.setCellValueFactory(new PropertyValueFactory<>("chem"));
            SSC_hm.setCellValueFactory(new PropertyValueFactory<>("h_math"));
            SSC_bio.setCellValueFactory(new PropertyValueFactory<>("bio"));
            ssc_tableview.setItems(showlist);
        }

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
                String query = null;
                if(class_cat(c)==1) query="INSERT INTO "+c+" VALUES (?,?,?,?,?,?)";
                else if(class_cat(c)==2 || class_cat(c)==3) query ="INSERT INTO "+c+" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                prepare = connect.prepareStatement(query);
                FileInputStream fule=new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(fule);
                XSSFSheet sheet = wb.getSheetAt(0);
                Row row;
                for(int i=1; i<=sheet.getLastRowNum(); i++)
                {
                    row=  sheet.getRow(i);
                    if(row.getCell(0)==null) break;
                    prepare.setString(1, row.getCell(0).getStringCellValue());
                    prepare.setInt(2, (int) row.getCell(1).getNumericCellValue());
                    prepare.setString(3, row.getCell(2).getStringCellValue());
                    prepare.setInt(4, (int) row.getCell(3).getNumericCellValue());
                    prepare.setInt(5, (int) row.getCell(4).getNumericCellValue());
                    prepare.setInt(6, (int) row.getCell(5).getNumericCellValue());
                    if(class_cat(c)==2 || class_cat(c)==3)
                    {
                        prepare.setInt(7, (int) row.getCell(6).getNumericCellValue());
                        prepare.setInt(8, (int) row.getCell(7).getNumericCellValue());
                        prepare.setInt(9, (int) row.getCell(8).getNumericCellValue());
                        prepare.setInt(10, (int) row.getCell(9).getNumericCellValue());
                        prepare.setInt(11, (int) row.getCell(10).getNumericCellValue());
                        prepare.setInt(12, (int) row.getCell(11).getNumericCellValue());
                    }
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
        ss="o";
        result_sub_pane1.setVisible(false);
        result_sub_pane2.setVisible(false);
        cls1_to_2_pane.setVisible(true);
        secondary_pane.setVisible(false);
        ssc_pane.setVisible(false);
        result_back_button.setVisible(true);
        print_btn.setVisible(true);

    }

    public void sec_resinit()
    {
        ss="o";
        result_sub_pane1.setVisible(false);
        result_sub_pane2.setVisible(false);
        secondary_pane.setVisible(true);
        ssc_pane.setVisible(false);
        cls1_to_2_pane.setVisible(false);
        result_back_button.setVisible(true);
        print_btn.setVisible(true);
    }

    public void ssc_resinit()
    {
        result_sub_pane1.setVisible(false);
        result_sub_pane2.setVisible(false);
        secondary_pane.setVisible(false);
        ssc_pane.setVisible(true);
        cls1_to_2_pane.setVisible(false);
        result_back_button.setVisible(true);
        print_btn.setVisible(true);

    }
    public String cc;
    public void res_one_btn_click()
    {
        cc="one";
        resinit();
        showData("");
    }
    public void res_two_btn_click()
    {
        cc="two";
        resinit();
        showData("");
    }
    public void res_three_btn_click()
    {
        cc="three";
        resinit();
        showData("");
    }
    public void res_four_btn_click()
    {
        cc="four";
        resinit();
        showData("");
    }
    public void res_five_btn_click()
    {
        cc="five";
        resinit();
        showData("");
    }
    public void res_six_btn_click()
    {
        cc="six";
        sec_resinit();
        showData("");
    }
    public void res_seven_btn_click()
    {
        cc="seven";
        sec_resinit();
        showData("");
    }
    public void res_eight_btn_click()
    {
        cc="eight";
        sec_resinit();
        showData("");
    }
    public void res_nine_btn_click()
    {
        ss="sci";
        cc="nine";
        ssc_resinit();
        showData("");
    }
    public void res_ten_btn_click()
    {
        ss="sci";
        cc="ten";
        ssc_resinit();
        showData("");
    }
    public void cmrc()
    {
        ss="com";
        SSC_phy.setText("Finance");
        SSC_chem.setText("Accounting");
        SSC_bio.setText("Banking");
        SSC_hm.setText("Science");
        showData("_com");

    }
    public void sci()
    {
        ss="sci";
        SSC_phy.setText("Phycics");
        SSC_chem.setText("Chemistry");
        SSC_bio.setText("Biology");
        SSC_hm.setText("Higher math");
        showData("");

    }
    public void res_back_btn_click()
    {
        result_sub_pane1.setVisible(true);
        result_sub_pane2.setVisible(true);
        secondary_pane.setVisible(false);
        ssc_pane.setVisible(false);
        cls1_to_2_pane.setVisible(false);
        result_back_button.setVisible(false);
        print_btn.setVisible(false);
    }
    public void sc()
    {
        dcsn.setVisible(false);
        getexcel(cc);
    }
    public void cm()
    {
        dcsn.setVisible(false);
        getexcel(cc+"_com");
    }
    public void tt()
    {

        dcsn.setVisible(true);

    }

    public void b1() {cc="one"; getexcel("one");}
    public void b2() {cc="two"; getexcel("two");}
    public void b3() {cc="three"; getexcel("three");}
    public void b4() {cc="four"; getexcel("four");}
    public void b5() {cc="five"; getexcel("five");}
    public void b6() {cc="six"; getexcel("six");}
    public void b7() {cc="seven"; getexcel("seven");}
    public void b8() {cc="eight"; getexcel("eight");}
    public void b9() {cc="nine"; tt();}
    public void b10() {cc="ten"; tt();}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}