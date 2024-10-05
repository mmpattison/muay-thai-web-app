package com.techelevator.model;

import java.time.LocalDate;

public class Tournament {

    private final String tournamentName;
    private final String location;
    private final LocalDate startDate;
    private final LocalDate endDate;



    public Tournament(String tournamentName, String location, LocalDate startDate, LocalDate endDate) {
        this.tournamentName = tournamentName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
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
