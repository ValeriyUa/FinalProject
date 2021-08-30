package com.alevel.selenium.restassured.model;

public class LoginViewModel {

    private String userName;
    private String password;

    public LoginViewModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginViewModel() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginViewModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
