package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.io.IOException;

public class DontUseSignupPageController {

    @FXML
    private TextField dobid;

    @FXML
    private TextField emailid;

    @FXML
    private TextField firstnameid;

    @FXML
    private TextField genderid;

    @FXML
    private TextField lastnameid;

    @FXML
    private TextField middlenameid;

    @FXML
    private TextField passwordid;

    @FXML
    private TextField phonenumberid;


    @FXML
    protected void onNextPageBtn(){
        try {
            App.setRoot("signuppage2.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String firstname = firstnameid.getText();
        System.out.println(firstname);
    }

    @FXML
    protected void onLoginButtonClick(){
        try {
            App.setRoot("loginpage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onTitleClick(){
        try {
            App.setRoot("mainmenu.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
