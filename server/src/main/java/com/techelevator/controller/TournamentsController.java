package com.techelevator.controller;

import com.techelevator.dao.FightDao;
import com.techelevator.dao.FighterDao;
import com.techelevator.dao.TournamentDao;
import com.techelevator.model.Fight;
import com.techelevator.model.Fighter;
import com.techelevator.model.Tournament;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tournaments")
@PreAuthorize("isAuthenticated()")
public class TournamentsController {

    private final TournamentDao tournamentDao;
    private final FighterDao fighterDao;

    private final FightDao fightDao;

    public TournamentsController(TournamentDao tournamentDao, FighterDao fighterDao, FightDao fightDao) {
        this.tournamentDao = tournamentDao;
        this.fighterDao = fighterDao;
        this.fightDao = fightDao;
    }


   // @RequestMapping(path = "/tournaments", method = RequestMethod.GET)
    // how to do it without putting the request mapping at top and get mapping below
   @PreAuthorize("permitAll")
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentDao.getAllTournaments();
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/{tournamentId}/fighters")
    public List <Fighter> getAllFightersForTournament(@PathVariable long tournamentId){
        return fighterDao.getAllFightersForTournament(tournamentId);
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/{tournamentId}/fights")
    public List <Fight> getAllFightsForTournament (@PathVariable long tournamentId){
        return fightDao.getAllFightsForTournament(tournamentId);
    }





}
