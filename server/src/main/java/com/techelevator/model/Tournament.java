package com.techelevator.model;

import java.time.LocalDate;

public class Tournament {

    private final String tournamentName;
    private final String location;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String imgUrl;



    public Tournament(String tournamentName, String location, LocalDate startDate, LocalDate endDate, String imgUrl) {
        this.tournamentName = tournamentName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imgUrl = imgUrl;
    }
    public String getTournamentName() {
        return tournamentName;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    @Override
    public String toString() {
        return "tournament{" +
                "tournamentName='" + tournamentName + '\'' +
                ", location='" + location + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }


}
