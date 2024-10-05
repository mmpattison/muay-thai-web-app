package com.techelevator.dao;

import com.techelevator.model.WeightClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface WeightClassDao {
    List<WeightClass> getAllWeightClasses();
}
