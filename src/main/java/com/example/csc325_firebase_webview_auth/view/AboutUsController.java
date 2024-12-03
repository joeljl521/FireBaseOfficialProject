package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;

import java.io.IOException;

// Controller class for the "About Us" view
public class AboutUsController {

    @FXML
    protected void onTitleClick(){
        try {
            App.setRoot("mainmenu.fxml");  // Navigate back to the main menu view
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
