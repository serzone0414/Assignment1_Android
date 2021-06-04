package com.example.log_in;

import java.io.Serializable;

public class Resident implements Serializable {

    private int residentID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double weight;
    private double height;
    private int age;
    private double bmi;
    private String gender;
    private String NHI;
    private String GP;
    private String medicalHistory;
    private String food;
    private String allergies;
    private String medication;
    private String warfarin;
    private String insulin;
    private String behaviours;
    private String concerns;
    private String dentures;
    private String equipment;
    private String culturalConsideration;
    private String pain;
    private String falls;
    private String wound;
    private String needAssessors;
    private String EPOAfamilyContact;
    private String leisure;
    private String pharmacy;

    public Resident() {
        NHI = "Null";
        GP = "Null";
        medicalHistory = "Null";
        food = "Null";
        allergies = "Null";
        medication = "Null";
        warfarin = "Null";
        insulin = "Null";
        behaviours = "Null";
        concerns = "Null";
        dentures = "Null";
        equipment = "Null";
        culturalConsideration = "Null";
        pain = "Null";
        falls = "Null";
        wound = "Null";
        needAssessors = "Null";
        EPOAfamilyContact = "Null";
        leisure = "Null";
        pharmacy= "Null";
    }

    public Resident(String fn, String ln, String dob, double w, double h, String g) {
        firstName = fn;
        lastName = ln;
        dateOfBirth = dob;
        weight = w;
        height = h;
        gender = g;
        NHI = "Null";
        GP = "Null";
        medicalHistory = "Null";
        food = "Null";
        allergies = "Null";
        medication = "Null";
        warfarin = "Null";
        insulin = "Null";
        behaviours = "Null";
        concerns = "Null";
        dentures = "Null";
        equipment = "Null";
        culturalConsideration = "Null";
        pain = "Null";
        falls = "Null";
        wound = "Null";
        needAssessors = "Null";
        EPOAfamilyContact = "Null";
        leisure = "Null";
        pharmacy= "Null";
    }

    public Resident(String fn, String ln, String dob, double w, double h, String g, int a, double b) {
        firstName = fn;
        lastName = ln;
        dateOfBirth = dob;
        weight = w;
        height = h;
        gender = g;
        age = a;
        bmi = b;
        NHI = "Null";
        GP = "Null";
        medicalHistory = "Null";
        food = "Null";
        allergies = "Null";
        medication = "Null";
        warfarin = "Null";
        insulin = "Null";
        behaviours = "Null";
        concerns = "Null";
        dentures = "Null";
        equipment = "Null";
        culturalConsideration = "Null";
        pain = "Null";
        falls = "Null";
        wound = "Null";
        needAssessors = "Null";
        EPOAfamilyContact = "Null";
        leisure = "Null";
        pharmacy= "Null";
    }

    public void setResidentID(int residentID) { this.residentID = residentID; }

    public int getResidentID() { return residentID; }

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


    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setBehaviours(String behaviours) {
        this.behaviours = behaviours;
    }

    public String getBehaviours() {
        return behaviours;
    }

    public void setConcerns(String concerns) {
        this.concerns = concerns;
    }

    public String getConcerns() {
        return concerns;
    }

    public void setCulturalConsideration(String culturalConsideration) {
        this.culturalConsideration = culturalConsideration;
    }

    public String getCulturalConsideration() {
        return culturalConsideration;
    }

    public void setDentures(String dentures) {
        this.dentures = dentures;
    }

    public String getDentures() {
        return dentures;
    }

    public void setEPOAfamilyContact(String EPOAfamilyContact) {
        this.EPOAfamilyContact = EPOAfamilyContact;
    }

    public String getEPOAfamilyContact() {
        return EPOAfamilyContact;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setFalls(String falls) {
        this.falls = falls;
    }

    public String getFalls() {
        return falls;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    public void setGP(String GP) {
        this.GP = GP;
    }

    public String getGP() {
        return GP;
    }

    public void setInsulin(String insulin) {
        this.insulin = insulin;
    }

    public String getInsulin() {
        return insulin;
    }

    public void setLeisure(String leisure) {
        this.leisure = leisure;
    }

    public String getLeisure() {
        return leisure;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getMedication() {
        return medication;
    }

    public void setNeedAssessors(String needAssessors) {
        this.needAssessors = needAssessors;
    }

    public String getNeedAssessors() {
        return needAssessors;
    }

    public void setNHI(String NHI) {
        this.NHI = NHI;
    }

    public String getNHI() {
        return NHI;
    }

    public void setPain(String pain) {
        this.pain = pain;
    }

    public String getPain() {
        return pain;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setWarfarin(String warfarin) {
        this.warfarin = warfarin;
    }

    public String getWarfarin() {
        return warfarin;
    }

    public void setWound(String wound) {
        this.wound = wound;
    }

    public String getWound() {
        return wound;
    }

}