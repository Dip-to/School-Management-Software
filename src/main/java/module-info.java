module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.school_management to javafx.fxml;
    exports com.example.school_management;
    exports com.example.crud;
    opens com.example.crud to javafx.fxml;
    exports com.example.controller;
    opens com.example.controller to javafx.fxml;
    exports com.example.subject;
    opens com.example.subject to javafx.fxml;

    requires java.sql;
    requires jasperreports;

    requires poi.ooxml.plus;
    requires sstool.poi.expand;
    requires poi.ooxml;
    requires poi.ooxml.schemas;
    requires xmlbeans;
    requires commons.collections;
    requires poi;

}