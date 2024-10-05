package com.techelevator.dao;

import com.techelevator.model.Tournament;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Component

public class JdbcTournamentDao implements  TournamentDao{

    private final JdbcTemplate template;

    private RowMapper<Tournament> mapper = new RowMapper<Tournament>() {
        @Override
        public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
            String tournamentName = rs.getString("tournament_name");
            String location = rs.getString("location");
            LocalDate startDate = rs.getDate("start_date").toLocalDate();
            LocalDate endDate = rs.getDate("end_date").toLocalDate();
            Tournament tournament = new Tournament(tournamentName,location, startDate,endDate);
            return tournament;
        }
    };//mapper is anonymous class in java in line implementation

    public JdbcTournamentDao(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Tournament> getAllTournaments() {

        return template.query("SELECT * FROM tournament", mapper);
    }
//    @Override
//    public Tournament getTournamentById(int tournamentId){
//        String sql = "SELECT * FROM tournament";
//        SqlRowSet results = template.queryForRowSet(sql);
//
//        if(results.next()){
//
//        }
//
//        return null;
//    }
//
//    @Override
//    public Tournament createTournament(Tournament newTournament){
//        return null;
//    }
//    @Override
//    public Tournament updateTournament(Tournament updatedTournament){
//        return null;
//    }
//    @Override
//    public Tournament deleteTournamentById(int tournamentId){
//        return null;
//    }









//   other way of doing the mapper
//    @Override
//    public List<Tournament> getAllTournaments() {
//        List<Tournament> tournaments = new ArrayList<>();
//
//        String sql = "SELECT * FROM tournament";
//
//        SqlRowSet rs = template.queryForRowSet(sql);
//
//        while(rs.next()){
//
//            Tournament tournament = mapRowToTournament(rs);
//            tournaments.add(tournament);
//
//        }
//
//        return tournaments;
//
//    }
//
//    private static Tournament mapRowToTournament(SqlRowSet rs) {
//        String tournamentName = rs.getString("tournament_name");
//        String location = rs.getString("location");
//        LocalDate startDate = rs.getDate("start_date").toLocalDate();
//        LocalDate endDate = rs.getDate("end_date").toLocalDate();
//        Tournament tournament = new Tournament(tournamentName,location, startDate,endDate);
//        return tournament;
//    }
}
