package com.example.school_management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class School extends Application
{
    private double x=0;
    private double y=0;
    @Override
    public void start(Stage stage) throws IOException
    {
       // Parent fxmlLoader = FXMLLoader.load(getClass().getResource("main_pane.fxml"));
          Parent fxmlLoader = FXMLLoader.load(getClass().getResource("classes.fxml"));

        Scene scene = new Scene(fxmlLoader);
        fxmlLoader.setOnMousePressed((MouseEvent event) ->
        {
                    x= event.getSceneX();
                    y=event.getSceneY();
                });
        fxmlLoader.setOnMouseDragged((MouseEvent event) ->
        {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);

        });

        stage.setTitle("School Management Software");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}