package com.techelevator.model;

public class Gym {

    private final int id;
    private final String gymName;
    private final String gymLocation;
    private final String kruName;
    private final String overallFightRecord;

    public Gym(int id, String gymName, String gymLocation, String kruName, String overallFightRecord) {
        this.id = id;
        this.gymName = gymName;
        this.gymLocation = gymLocation;
        this.kruName = kruName;
        this.overallFightRecord = overallFightRecord;
    }

    public int getId() {
        return id;
    }

    public String getGymName() {
        return gymName;
    }

    public String getGymLocation() {
        return gymLocation;
    }

    public String getKruName() {
        return kruName;
    }

    public String getOverallFightRecord() {
        return overallFightRecord;
    }

    @Override
    public String toString() {
        return "Gym{" +
                "gymName='" + gymName + '\'' +
                ", gymLocation='" + gymLocation + '\'' +
                ", kruName='" + kruName + '\'' +
                ", overallFightRecord='" + overallFightRecord + '\'' +
                '}';
    }
}
