package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;


import java.io.IOException;


public class UserAccountInfoController {

    @FXML
    protected void LogOutBtn(){
        try {
            App.setRoot("mainmenu.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
