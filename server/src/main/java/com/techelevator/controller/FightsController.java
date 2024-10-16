package com.techelevator.controller;

import com.techelevator.dao.FightDao;
import com.techelevator.dao.FighterDao;
import com.techelevator.model.Fight;
import com.techelevator.model.Fighter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fights")
@PreAuthorize("isAuthenticated()")
public class FightsController {

    private final FightDao fightDao;
    private final FighterDao fighterDao;


    public FightsController(FightDao fightDao, FighterDao fighterDao) {
        this.fightDao = fightDao;
        this.fighterDao = fighterDao;
    }
    @PreAuthorize("permitAll")
    @GetMapping
    public List<Fight> getAllFights(){
        return fightDao.getAllFights();
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/{fightId}/fighters")
    public List <Fighter> getAllFightersForFight(@PathVariable long fightId){
        return fighterDao.getAllFightersForFight(fightId);
    }



}
