module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.school_management to javafx.fxml;
    exports com.example.school_management;
    exports com.example.crud;
    opens com.example.crud to javafx.fxml;
    exports com.example.dashboard;
    opens com.example.dashboard to javafx.fxml;
    requires java.sql;

}