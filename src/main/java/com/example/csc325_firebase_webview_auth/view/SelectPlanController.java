package com.example.csc325_firebase_webview_auth.view;

import javafx.fxml.FXML;

import java.io.IOException;

public class SelectPlanController {

    @FXML
    protected void SelectPlan1() {

    }

    @FXML
    protected void SelectPlan2() {

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
