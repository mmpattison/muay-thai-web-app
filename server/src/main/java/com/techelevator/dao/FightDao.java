package com.techelevator.dao;

import com.techelevator.model.Fight;

import java.util.List;

public interface FightDao {
    List<Fight> getAllFights();

    List<Fight> getAllFightsForTournament(long tournamentId);
}
