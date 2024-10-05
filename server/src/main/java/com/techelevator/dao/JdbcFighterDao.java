package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Fighter;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFighterDao implements FighterDao {


    private final JdbcTemplate template;

    public JdbcFighterDao(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }





    @Override
    public List<Fighter> getAllFighters() {
        List<Fighter> fighters = new ArrayList<>();

        String sql = "SELECT * FROM fighter";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {

            Fighter fighter = mapRowToFighter(rs);
            fighters.add(fighter);

        }

        return fighters;

    }

    @Override
    public List<Fighter> getAllFightersForTournament(long tournamentId){
        List <Fighter> fighters = new ArrayList<>();
        String sql = "Select * FROM fighter as f " +
                "JOIN registration as r on f.fighter_id = r.fighter_id " +
                "JOIN tournament as t on t.tournament_id = r.tournament_id " +
                "WHERE t.tournament_id = ?";
        SqlRowSet rs = template.queryForRowSet(sql, tournamentId);

        while (rs.next()){
            Fighter fighter = mapRowToFighter(rs);
            fighters.add(fighter);
        }
        return fighters;
    }

    @Override
    public List<Fighter> getAllFightersForWeightClass(long weightClassId){
        List <Fighter> fighters = new ArrayList<>();
        String sql = "SELECT * FROM fighter WHERE current_weight_class_id = ?";

        SqlRowSet rs = template.queryForRowSet(sql, weightClassId);

        while (rs.next()){
            Fighter fighter = mapRowToFighter(rs);
            fighters.add(fighter);
        }
        return fighters;
    }

    @Override
    public List<Fighter> getAllFightersForGym (long gymId){
        List<Fighter> fighters = new ArrayList<>();
        String sql = "Select * FROM fighter WHERE current_gym_id = ?";

        SqlRowSet rs = template.queryForRowSet(sql, gymId);
        while (rs.next()){
            Fighter fighter = mapRowToFighter(rs);
            fighters.add(fighter);
        }
        return fighters;
    }


    @Override
    public Fighter getFighterById(long fighterId) {
        Fighter fighter = null;

        String sql = "SELECT * FROM fighter WHERE fighter_id =?";
        try {
            SqlRowSet rs = template.queryForRowSet(sql, fighterId);
            if (rs.next()) {
                fighter = mapRowToFighter(rs);
            }
        } catch (DataAccessException e) {
            throw new RuntimeException(e);

        }

        return fighter;
    }



    @Override
    public Fighter createFighter(Fighter fighter) {
        Fighter newFighter;
        String sql = "INSERT INTO fighter (fighter_name, current_weight_class_id, fighter_experience_level, fighter_age, fighter_height," +
                "fighter_gender, fighter_record, current_gym_id, fighter_location, fighter_email, fighter_registration_status)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?) RETURNING fighter_id;";
        try{
            long fighterId = template.queryForObject(sql, int.class, fighter.getFighterName(), fighter.getCurrentWeightClassId(), fighter.getFighterExperienceLevel(), fighter.getFighterAge(),
                    fighter.getFighterHeight(), fighter.getFighterGender(), fighter.getFighterRecord(), fighter.getCurrentGymId(), fighter.getFighterLocation(),
                    fighter.getFighterEmail(), fighter.getFighterRegistrationStatus());
            newFighter = getFighterById(fighterId);

        }  catch (
    CannotGetJdbcConnectionException e) {
        throw new DaoException("Unable to connect to server or database", e);
    } catch (
    DataIntegrityViolationException e) {
        throw new DaoException("Data integrity violation", e);
    }
        return newFighter;
    }

    @Override
    public Fighter updateFighter(Fighter fighter, long fighterId) {
        Fighter updatedFighter = null;
        String sql = "UPDATE fighter SET fighter_name = ?, current_weight_class_id = ?, fighter_experience_level = ?, fighter_age = ?, fighter_height = ?," +
                "fighter_gender = ?, fighter_record = ?, current_gym_id = ?, fighter_location = ?, fighter_email = ?, fighter_registration_status = ? " +
                "WHERE fighter_id = ? ";
        try {
            int rowsAffected = template.update(sql, fighter.getFighterName(), fighter.getCurrentWeightClassId(), fighter.getFighterExperienceLevel(), fighter.getFighterAge(),
                    fighter.getFighterHeight(), fighter.getFighterGender(), fighter.getFighterRecord(), fighter.getCurrentGymId(), fighter.getFighterLocation(),
                    fighter.getFighterEmail(), fighter.getFighterRegistrationStatus(), fighterId);
            if(rowsAffected == 0){
                throw new DaoException("Zero rows affected, expected at least one");
            }
            updatedFighter = getFighterById(fighterId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (Exception e){
            throw new DaoException("bad");
        }
        return updatedFighter;
    }

    @Override
    public int deleteFighterById(long fighterId) {
        int numberOfRows = 0;
        String deleteFighterFromFightRedCorner = "DELETE FROM fight WHERE red_corner_id = ?";
        String deleteFighterFromFightBlueCorner = "DELETE FROM fight WHERE blue_corner_id =?";
        String deleteRegistration ="DELETE FROM registration WHERE fighter_id=?";
        String deleteFighterSql = "DELETE FROM fighter WHERE fighter_id =?";
        try{
            template.update(deleteFighterFromFightRedCorner,fighterId);
            template.update(deleteFighterFromFightBlueCorner,fighterId);
            template.update(deleteRegistration,fighterId);
            numberOfRows=template.update(deleteFighterSql, fighterId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }

    private Fighter mapRowToFighter(SqlRowSet rs) {

        String fighterName = rs.getString("fighter_name");
        int currentWeightClassID = rs.getInt("current_weight_class_id");
        String fighterExperienceLevel = rs.getString("fighter_experience_level");
        int fighterAge = rs.getInt("fighter_age");
        String fighterHeight = rs.getString("fighter_height");
        String fighterGender = rs.getString("fighter_gender");
        String fighterRecord = rs.getString("fighter_record");
        int currentGymId = rs.getInt("current_gym_id");
        String fighterLocation = rs.getString("fighter_location");
        String fighterEmail = rs.getString("fighter_email");
        String fighterRegistrationStatus = rs.getString("fighter_registration_status");
        Fighter fighter = new Fighter( fighterName, currentWeightClassID, fighterExperienceLevel, fighterAge, fighterHeight,
                fighterGender, fighterRecord, currentGymId, fighterLocation, fighterEmail, fighterRegistrationStatus);
        return fighter;
    }

}
