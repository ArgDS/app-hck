package com.group.first.app.dao;

import com.group.first.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonDAO {

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;
    NamedParameterJdbcTemplate npjt;

    public PersonDAO() {
        npjt = new NamedParameterJdbcTemplate(dataSource);
    }

    public Person getPerson(long id){
        String sql = "Select * from person where id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return npjt.queryForObject(sql, paramMap, new BeanPropertyRowMapper<Person>());
    }

    public void addPerson(Person person){

    }

    public void clearAllPersons(){

    }

}
