package com.example.log_in;

import java.io.Serializable;

public class Account implements Serializable {


    private int ID;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Account(){

    }

    public Account(String u, String p){
        username = u;
        password = p;
    }




    public void setID(int ID) { this.ID = ID; }

    public int getID() { return ID; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
