package com.techelevator.controller;

import com.techelevator.dao.FighterDao;
import com.techelevator.model.Fighter;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/fighters")
@PreAuthorize("isAuthenticated()")
public class FightersController {

    private final FighterDao fighterDao;

    public FightersController(FighterDao fighterDao) {
        this.fighterDao = fighterDao;
    }

    @PreAuthorize("permitAll")
    @GetMapping
    public List<Fighter> getAllFighters(){
    return fighterDao.getAllFighters();
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/{fighterId}")
    public Fighter getFighterById(@PathVariable long fighterId){
        Fighter fighter = fighterDao.getFighterById(fighterId);
                if( fighter == null){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fighter not found");
                } else {
                    return fighter;
                }
    }


    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Fighter createFighter (@RequestBody Fighter fighter){
        return fighterDao.createFighter(fighter);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/{fighterId}")
    public Fighter updateFighter( @RequestBody Fighter fighter, @PathVariable long fighterId){
        return fighterDao.updateFighter( fighter, fighterId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path= "/{fighterId}")
    public void deleteFighter(@PathVariable long fighterId){
        fighterDao.deleteFighterById(fighterId);
    }











}
