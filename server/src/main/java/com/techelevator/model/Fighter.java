package com.techelevator.model;

public class Fighter {

    private final int id;
    private final String fighterName;

    private final long currentWeightClassId;
    private final String fighterExperienceLevel;
    private final int fighterAge;


    private final String fighterHeight;
    private final String fighterGender;

    private final String fighterRecord;

    private final long currentGymId;
    private final String fighterLocation;
    private final String fighterEmail;
    private final String fighterRegistrationStatus;
    private final String imgUrl;




    public Fighter(int id, String fighterName, long currentWeightClassId, String fighterExperienceLevel, int fighterAge, String fighterHeight, String fighterGender, String fighterRecord, long currentGymId, String fighterLocation, String fighterEmail, String fighterRegistrationStatus, String imgUrl) {
        this.id = id;
        this.fighterName = fighterName;
        this.currentWeightClassId = currentWeightClassId;
        this.fighterExperienceLevel = fighterExperienceLevel;
        this.fighterAge = fighterAge;
        this.fighterHeight = fighterHeight;
        this.fighterGender = fighterGender;
        this.fighterRecord = fighterRecord;
        this.currentGymId = currentGymId;
        this.fighterLocation = fighterLocation;
        this.fighterEmail = fighterEmail;
        this.fighterRegistrationStatus = fighterRegistrationStatus;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public String getFighterName() {
        return fighterName;
    }

    public long getCurrentWeightClassId() {
        return currentWeightClassId;
    }

    public String getFighterExperienceLevel() {
        return fighterExperienceLevel;
    }

    public int getFighterAge() {
        return fighterAge;
    }

    public String getFighterHeight() {
        return fighterHeight;
    }

    public String getFighterGender() {
        return fighterGender;
    }

    public String getFighterRecord(){
        return  fighterRecord;
    }

    public long getCurrentGymId(){
        return currentGymId;
    }

    public String getFighterLocation() {
        return fighterLocation;
    }

    public String getFighterEmail() {
        return fighterEmail;
    }

    public String getFighterRegistrationStatus() {
        return fighterRegistrationStatus;
    }
    public String getImgUrl() {
        return imgUrl;
    }


    @Override
    public String toString() {
        return "Fighter{" +
                "fighterName='" + fighterName + '\'' +
                ", fighterExperienceLevel='" + fighterExperienceLevel + '\'' +
                ", fighterAge=" + fighterAge +
                ", fighterHeight='" + fighterHeight + '\'' +
                ", fighterGender='" + fighterGender + '\'' +
                ", fighterRecord='" + fighterRecord + '\'' +
                ", fighterLocation='" + fighterLocation + '\'' +
                ", fighterEmail='" + fighterEmail + '\'' +
                ", fighterRegistrationStatus='" + fighterRegistrationStatus + '\'' +
                '}';
    }


}
