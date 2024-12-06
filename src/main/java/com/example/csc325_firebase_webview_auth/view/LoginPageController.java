package com.example.csc325_firebase_webview_auth.view;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoginPageController {

    @FXML
    private TextField PasswordId;

    @FXML
    private TextField UserNameId;



    @FXML
    protected void LoginBtn() throws IOException {
        String email = UserNameId.getText();
        String password = PasswordId.getText();

        boolean authenticated = authenticateUser(email, password);

        if (authenticated) {
            App.setRoot("useraccountinfo.fxml");
        } else {
            System.out.println("Error: Not Authenticated");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Info");
            alert.setContentText("Email||password is incorrect.");
            alert.showAndWait();
        }
    }

    /**
     * This method will check the user input with the Firebase database to see if the email and password
     * combination exist.
     *
     * @param email
     * @param password
     * @return
     */
    private boolean authenticateUser(String email, String password) {
        CollectionReference users = App.fstore.collection("Users");


        Query query = users.whereEqualTo("Email Address", email).whereEqualTo("Password", password);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        try {
            List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
            return !documents.isEmpty(); // Return true if the query returned any documents (user exists with the given email and password)
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }
    @FXML

    protected void createaccountbtn(){
        try {
            App.setRoot("signuppage.fxml");
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


