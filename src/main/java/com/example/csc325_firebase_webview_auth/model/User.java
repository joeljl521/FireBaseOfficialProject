package com.example.csc325_firebase_webview_auth.model;

public class User  {

    private String firstName;
    private String lastName;
    private String Dob;
    private String middleName;
    private String email;
    private String gender;
    private String phoneNumber;
    private String password;
    private String streetAddress;
    private String etcId;
    private String city;
    private String state;
    private String zipcode;
    private String incomeRange;
    private String houseHoldSize;


    public User(String firstName, String lastName, String dob, String middleName, String email, String gender, String phoneNumber, String password, String streetAddress, String etcId, String city, String state, String zipcode, String incomeRange, String houseHoldSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Dob = dob;
        this.middleName = middleName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.streetAddress = streetAddress;
        this.etcId = etcId;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.incomeRange = incomeRange;
        this.houseHoldSize = houseHoldSize;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getEtcId() {
        return etcId;
    }

    public void setEtcId(String etcId) {
        this.etcId = etcId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getIncomeRange() {
        return incomeRange;
    }

    public void setIncomeRange(String incomeRange) {
        this.incomeRange = incomeRange;
    }

    public String getHouseHoldSize() {
        return houseHoldSize;
    }

    public void setHouseHoldSize(String houseHoldSize) {
        this.houseHoldSize = houseHoldSize;
    }




    }

