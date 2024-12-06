package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;

import java.io.IOException;

public class SelectPlanController {

    @FXML
    protected void SelectPlan1() {
        try {
            App.setRoot("useraccountinfo.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    protected void SelectPlan2() {
        try {
            App.setRoot("useraccountinfo.fxml");
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
