package com.techelevator.controller;


import com.techelevator.dao.FighterDao;
import com.techelevator.dao.GymDao;
import com.techelevator.model.Fighter;
import com.techelevator.model.Gym;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/gyms")
@PreAuthorize("isAuthenticated()")
public class GymsController {

    private final GymDao gymDao;
    private final FighterDao fighterDao;


    public GymsController(GymDao gymDao, FighterDao fighterDao) {
        this.gymDao = gymDao;
        this.fighterDao = fighterDao;
    }
    @PreAuthorize("permitAll")
    @GetMapping
    public List<Gym> getAllGyms(){
      return gymDao.getAllGyms();
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/{gymId}/fighters")
    public List<Fighter> getAllFightersForGym(@PathVariable long gymId){
        return fighterDao.getAllFightersForGym(gymId);

    }
}
