package com.techelevator.model;

public class Fight {
    private final int id;

    public final int blueCornerId;

    public final int redCornerId;

    public final String winner;
    public final String loser;
    public final String winType;



    public final int tournamentId;

    public final String fightName;

    public Fight(int id, int blueCornerId, int redCornerId, String winner, String loser, String winType, int tournamentId, String fightName) {
        this.id = id;
        this.blueCornerId = blueCornerId;
        this.redCornerId = redCornerId;
        this.winner = winner;
        this.loser = loser;
        this.winType = winType;
        this.tournamentId = tournamentId;
        this.fightName = fightName;
    }

    public int getId() {
        return id;
    }

    public int getBlueCornerId() {
        return blueCornerId;
    }

    public int getRedCornerId() {
        return redCornerId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public String getWinner() {
        return winner;
    }

    public String getLoser() {
        return loser;
    }

    public String getWinType() {
        return winType;
    }

    public String getFightName() {
        return fightName;
    }

    @Override
    public String toString() {
        return "Fight{" +
                "winner='" + winner + '\'' +
                ", loser='" + loser + '\'' +
                ", winType='" + winType + '\'' +
                '}';
    }
}
