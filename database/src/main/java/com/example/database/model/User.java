package com.example.database.model;

public class User {
    private String name;
    private String password;
    private String salt;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.password = "";
        this.salt = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
