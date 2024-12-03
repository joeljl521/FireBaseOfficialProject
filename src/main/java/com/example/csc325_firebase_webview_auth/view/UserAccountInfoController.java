package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;


import java.io.IOException;

// Controller class for the User Account Information view
public class UserAccountInfoController {

    @FXML
    protected void LogOutBtn(){
        try {
            App.setRoot("mainmenu.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);  // Handle any IO exceptions during navigation
        }
    }
}
