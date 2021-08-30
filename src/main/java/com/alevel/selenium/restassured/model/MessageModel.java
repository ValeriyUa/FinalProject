package com.alevel.selenium.restassured.model;

public class MessageModel {

    private int code;
    private String message;


    public MessageModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public MessageModel() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
