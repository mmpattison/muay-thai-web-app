package com.techelevator.dao;

import com.techelevator.model.Fight;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcFightDao implements  FightDao{

    private final JdbcTemplate template;

    public JdbcFightDao(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Fight> getAllFights(){
       List <Fight> fights = new ArrayList<>();
       String sql = "SELECT * FROM fight";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()){
           Fight fight =  mapRowToFight(rs);
           fights.add(fight);
        }
        return fights;
    }

    @Override
    public List<Fight> getAllFightsForTournament(long tournamentId){
        List <Fight> fights = new ArrayList<>();
        String sql = "Select * FROM fight WHERE tournament_id = ?";

        SqlRowSet rs = template.queryForRowSet(sql, tournamentId);
        while (rs.next()){
            Fight fight = mapRowToFight(rs);
            fights.add(fight);
        }

        return fights;
    }

    private static Fight mapRowToFight(SqlRowSet rs) {
        int id =rs.getInt("fight_id");
        int blueCornerId = rs.getInt("blue_corner_id");
        int redCornerId = rs.getInt("red_corner_id");
        String winner = rs.getString("winner");
        String loser = rs.getString("loser");
        String winType = rs.getString("win_type");
        int tournamentId = rs.getInt("tournament_id");
        String fightName = rs.getString("fight_name");
        Fight fight = new Fight(id, blueCornerId, redCornerId, winner, loser, winType, tournamentId, fightName);
        return fight;
    }
}
