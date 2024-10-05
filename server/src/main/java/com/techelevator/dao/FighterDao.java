package com.techelevator.dao;

import com.techelevator.model.Fighter;

import java.util.List;

public interface FighterDao {
    List<Fighter> getAllFighters();

    List<Fighter> getAllFightersForTournament(long tournamentId);

    List<Fighter> getAllFightersForWeightClass(long weightClassId);

    List<Fighter> getAllFightersForGym(long gymId);

    Fighter getFighterById(long fighterId);

    Fighter createFighter(Fighter createdFighter);

    Fighter updateFighter(Fighter updatedFighter, long fighterId);


    int deleteFighterById(long fighterId);


}
