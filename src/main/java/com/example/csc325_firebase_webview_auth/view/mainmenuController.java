package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;

import java.io.IOException;

// Controller class for the main menu view
public class mainmenuController {

    @FXML
    protected void AboutUsBtn(){
        try {
            App.setRoot("aboutus.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onLoginButtonClick(){
        try {
            App.setRoot("loginpage.fxml");  // Navigate to the login page
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onSignUpBtn() {
        try {
            App.setRoot("signuppage.fxml");     // Navigate to the sign-up page
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
