package com.techelevator.controller;

import com.techelevator.dao.FighterDao;
import com.techelevator.dao.WeightClassDao;
import com.techelevator.model.Fighter;
import com.techelevator.model.WeightClass;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/weightClasses")
@PreAuthorize("isAuthenticated()")
public class WeightClassesController {

    private final WeightClassDao weightClassDao;
    private final FighterDao fighterDao;


    public WeightClassesController(WeightClassDao weightClassDao, FighterDao fighterDao) {
        this.weightClassDao = weightClassDao;
        this.fighterDao = fighterDao;
    }

    @PreAuthorize("permitAll")
    @GetMapping
    public List<WeightClass> getAllWeightClasses(){
        return weightClassDao.getAllWeightClasses();
    }
    @PreAuthorize("permitAll")
    @GetMapping(path = "/{weightClassId}/fighters")
    public List<Fighter> getAllFightersForWeightClass(@PathVariable long weightClassId){
        return fighterDao.getAllFightersForWeightClass(weightClassId);

    }
}
