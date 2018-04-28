package com.group.first.app.dao;

import com.group.first.app.model.Person;
import com.group.first.app.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Repository
public class StatisticDAO {

    @Autowired
    NamedParameterJdbcTemplate npjt;

    final String SQL_PERSON = "Select count(*) from person"; //в один бы запрос
    final String SQL_CAR = "Select count(*) from car";

    public Statistics getStatistic() {


        Statistics statistics = new Statistics();

        statistics.setPersoncount(npjt.queryForObject(SQL_PERSON, new EmptySqlParameterSource(), Long.class));
        statistics.setPersoncount(npjt.queryForObject(SQL_CAR, new EmptySqlParameterSource(), Long.class));

        return statistics;
    }


}
