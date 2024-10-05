package com.techelevator.controller;

import com.techelevator.dao.FightDao;
import com.techelevator.model.Fight;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fights")
@PreAuthorize("isAuthenticated()")
public class FightsController {

    private final FightDao fightDao;


    public FightsController(FightDao fightDao) {
        this.fightDao = fightDao;
    }
    @PreAuthorize("permitAll")
    @GetMapping
    public List<Fight> getAllFights(){
        return fightDao.getAllFights();
    }
    @PreAuthorize("permitAll")
    @GetMapping(path = "/{tournamentId}/fights")
    public List <Fight> getAllFightsForTournament (@PathVariable long tournamentId){
        return fightDao.getAllFightsForTournament(tournamentId);
    }


}
