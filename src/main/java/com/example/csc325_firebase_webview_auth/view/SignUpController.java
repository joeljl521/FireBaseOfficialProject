package com.example.csc325_firebase_webview_auth.view;//package modelview;

import com.example.csc325_firebase_webview_auth.model.Person;
import com.example.csc325_firebase_webview_auth.viewmodel.AccessDataViewModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SignUpController {


    @FXML
    private TextField nameField;
    @FXML
    private TextField majorField;
    @FXML
    private TextField ageField;
    @FXML
    private Button writeButton;
    @FXML
    private Button readButton;
    @FXML
    private TextArea outputField;



    private boolean key;
    private ObservableList<Person> listOfUsers = FXCollections.observableArrayList();
    private Person person;
    public ObservableList<Person> getListOfUsers() {
        return listOfUsers;
    }

    void initialize() {

        AccessDataViewModel accessDataViewModel = new AccessDataViewModel();
        nameField.textProperty().bindBidirectional(accessDataViewModel.userNameProperty());
        majorField.textProperty().bindBidirectional(accessDataViewModel.userMajorProperty());
        writeButton.disableProperty().bind(accessDataViewModel.isWritePossibleProperty().not());
    }

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
    private TextField streetaddressid;

    @FXML
    private TextField etcid;

    @FXML
    private TextField cityid;

    @FXML
    private TextField stateid;

    @FXML
    private TextField zipcodeid;

    @FXML
    private TextField incomerangeid;

    @FXML
    private TextField householdsizeid;

    public static String username;
    public static String email;
    public static String password;
    public static String firstname;
    public static String lastname;
    public static String incomerange;
    public static String householdsize;



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



    @FXML
    private void addRecord(ActionEvent event) {ApplyBtn();
    }

    @FXML
    private void readRecord(ActionEvent event) {
        readFirebase();
    }

    @FXML
    private void regRecord(ActionEvent event) {
        registerUser();
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("/files/WebContainer.fxml");
    }

    @FXML
    public void ApplyBtn() {

        username = emailid.getText();
        email = emailid.getText();
        password = passwordid.getText();
        firstname = firstnameid.getText();
        lastname = lastnameid.getText();
        incomerange = incomerangeid.getText();
        householdsize = householdsizeid.getText();

//        DocumentReference docRef = App.fstore.collection("References").document(UUID.randomUUID().toString());
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("Name", nameField.getText());
//        data.put("Major", majorField.getText());
//        data.put("Age", Integer.parseInt(ageField.getText()));
//        //asynchronously write data
//        ApiFuture<WriteResult> result = docRef.set(data);

        DocumentReference docRef = App.fstore.collection("Users").document(UUID.randomUUID().toString());

        Map<String, Object> data = new HashMap<>();
        data.put("First Name", firstnameid.getText());
        data.put("Last Name", lastnameid.getText());
        data.put("Date of Birth", dobid.getText());
        data.put("Middle Name", middlenameid.getText());
        data.put("Email Address", emailid.getText());
        data.put("Gender", genderid.getText());
        data.put("Mobile Phone Number", phonenumberid.getText());
        data.put("Password", passwordid.getText());
        data.put("Street Address", streetaddressid.getText());
        data.put("Apt, Suite, Floor, ETC", etcid.getText());
        data.put("City", cityid.getText());
        data.put("State", stateid.getText());
        data.put("Zip Code", zipcodeid.getText());
        data.put("Income Range", incomerangeid.getText());
        data.put("Household Size", householdsizeid.getText());




        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);

        try {
            App.setRoot("selectplan.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean readFirebase()
    {
        key = false;

        //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future =  App.fstore.collection("Users").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents;
        try
        {
            documents = future.get().getDocuments();
            if(documents.size()>0)
            {
                System.out.println("Outing....");
                for (QueryDocumentSnapshot document : documents)
                {
                    outputField.setText(outputField.getText()+ document.getData().get("Name")+ " , Major: "+
                            document.getData().get("Major")+ " , Age: "+
                            document.getData().get("Age")+ " \n ");
                    System.out.println(document.getId() + " => " + document.getData().get("Name"));
                    person  = new Person(String.valueOf(document.getData().get("Name")),
                            document.getData().get("Major").toString(),
                            Integer.parseInt(document.getData().get("Age").toString()));
                    listOfUsers.add(person);
                }
            }
            else
            {
                System.out.println("No data");
            }
            key=true;

        }
        catch (InterruptedException | ExecutionException ex)
        {
            ex.printStackTrace();
        }
        return key;
    }

    public void sendVerificationEmail() {
        try {
            UserRecord user = App.fauth.getUser("name");
            //String url = user.getPassword();

        } catch (Exception e) {
        }
    }

    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail("user@example.com")
                .setEmailVerified(false)
                .setPassword("secretPassword")
                .setPhoneNumber("+11234567890")
                .setDisplayName("John Doe")
                .setDisabled(false);

        UserRecord userRecord;
        try {
            userRecord = App.fauth.createUser(request);
            System.out.println("Successfully created new user: " + userRecord.getUid());
            return true;

        } catch (FirebaseAuthException ex) {
            // Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
