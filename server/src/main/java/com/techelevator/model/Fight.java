package com.techelevator.model;

public class Fight {

    public final int blueCornerId;

    public final int redCornerId;

    public final String winner;
    public final String loser;
    public final String winType;

    public final int tournamentId;

    public Fight(int blueCornerId, int redCornerId, String winner, String loser, String winType, int tournamentId) {
        this.blueCornerId = blueCornerId;
        this.redCornerId = redCornerId;
        this.winner = winner;
        this.loser = loser;
        this.winType = winType;
        this.tournamentId = tournamentId;
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

    @Override
    public String toString() {
        return "Fight{" +
                "winner='" + winner + '\'' +
                ", loser='" + loser + '\'' +
                ", winType='" + winType + '\'' +
                '}';
    }
}
