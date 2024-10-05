package com.techelevator.dao;

import com.techelevator.model.Gym;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcGymDao implements GymDao{

    private final JdbcTemplate template;


    public JdbcGymDao(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    @Override

    public List<Gym> getAllGyms(){
        List <Gym> gyms = new ArrayList<>();
        String sql = "SELECT * FROM gym";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()){
            Gym gym = mapRowToGym(rs);

            gyms.add(gym);
        }
        return gyms;
    }

    private static Gym mapRowToGym(SqlRowSet rs) {
        String gymName = rs.getString("gym_name");
        String gymLocation = rs.getString("gym_location");
        String kruName = rs.getString("kru_name");
        String overallGymRecord = rs.getString("overall_gym_record");
        Gym gym = new Gym(gymName, gymLocation, kruName, overallGymRecord);
        return gym;
    }


}
