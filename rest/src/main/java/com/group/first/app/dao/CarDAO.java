package com.group.first.app.dao;

import com.group.first.app.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarDAO {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarDAO(@Autowired @Qualifier("jdbcTemplate")NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void addCar(Car car) {
        String query = "INSERT INTO CAR (ID, MODEL, VENDOR, HORSEPOWER, OWNERID) VALUES (:id, :model, :vendor, :horsepower, :ownerid)";
        Map namedParameters = new HashMap(4);
        namedParameters.put("id", car.getId());
        namedParameters.put("model", car.getModel().substring(car.getModel().indexOf('-')) + 1);
        namedParameters.put("vendor", car.getModel().substring(0, car.getModel().indexOf('-')));
        namedParameters.put("horsepower", car.getHorsePower());
        namedParameters.put("ownerid", car.getOunerId());
        namedParameterJdbcTemplate.update(query, namedParameters);
    }

    public Car getCar(Long id) {
        String sql = "SELECT * FROM CAR WHERE ID = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<Car>());
    }

    public void clearAll() {
        String sql = "DELETE FROM CAR";
        namedParameterJdbcTemplate.update(sql, new HashMap<String, Object>());
    }

}
