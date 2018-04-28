package com.group.first.app.services;

import com.group.first.app.dao.StatisticDAO;
import com.group.first.app.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    @Autowired
    StatisticDAO statisticDAO;

    public Statistics getStatic() {
        return statisticDAO.getStatistic();
    }

}
