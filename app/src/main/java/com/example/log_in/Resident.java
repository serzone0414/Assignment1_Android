package com.example.log_in;

import java.io.Serializable;

public class Resident implements Serializable {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double weight;
    private double height;
    private int age;
    private double bmi;
    private String gender;

    public Resident() {

    }

    public Resident(String fn, String ln, String dob, double w, double h, String g) {
        firstName = fn;
        lastName = ln;
        dateOfBirth = dob;
        weight = w;
        height = h;
        gender = g;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBmi() {
        return bmi;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}