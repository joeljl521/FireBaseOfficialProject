package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.io.IOException;

// Controller class for the User Account Information view
public class UserAccountInfoController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField incomeField;

    @FXML
    private TextField householdField;

    @FXML
    public void initialize() {
        if (SignUpController.email != null) {
            usernameField.setText(SignUpController.email);
        }

        if (SignUpController.email != null) {
            emailField.setText(SignUpController.email);
        }

        if (SignUpController.firstname != null) {
            firstNameField.setText(SignUpController.firstname + " " + SignUpController.lastname);
        }

        if (SignUpController.password != null) {
            passwordField.setText(SignUpController.password);
        }

        if (SignUpController.incomerange != null) {
            incomeField.setText(SignUpController.incomerange);
        }

        if (SignUpController.householdsize != null) {
            householdField.setText(SignUpController.householdsize);
        }
    }

    @FXML
    protected void LogOutBtn(){
        try {
            App.setRoot("mainmenu.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);  // Handle any IO exceptions during navigation
        }
    }
}