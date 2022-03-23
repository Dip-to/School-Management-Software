package com.example.school_management;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class paneLoader {
    private Pane view;
    public Pane getfxmlfile(String s) throws IOException
    {
        System.out.println("find "+s);
        URL ff= School.class.getResource(s+".fxml");
        if(ff==null)
        {
            System.out.println("Cant find "+s);
        }
        view=new FXMLLoader().load(ff);
        return view;
    }
}
