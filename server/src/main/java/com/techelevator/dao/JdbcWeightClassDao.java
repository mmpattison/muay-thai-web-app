package com.techelevator.dao;

import com.techelevator.model.WeightClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcWeightClassDao implements WeightClassDao{

    private final JdbcTemplate template;

    public  JdbcWeightClassDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }



    @Override
    public List<WeightClass> getAllWeightClasses() {

        List<WeightClass> weightClasses = new ArrayList<>();

        String sql = "SELECT * FROM weight_class";
        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()){
           WeightClass weightClass = mapRowToWeightClass(rs);
           weightClasses.add(weightClass);
        }

        return weightClasses;
    }

    private WeightClass mapRowToWeightClass(SqlRowSet rs) {
        String weightClassName = rs.getString("weight_class_name");
        double minimumWeight = rs.getDouble("minimum_weight");
        double maximumWeight = rs.getDouble("maximum_weight");
        WeightClass weightClass = new WeightClass(weightClassName, minimumWeight, maximumWeight);
        return weightClass;
    }
}
