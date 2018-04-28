package com.group.first.app.facade;

import com.group.first.app.model.Statistics;
import com.group.first.app.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticFacade {

    @Autowired
    StatisticService statisticService;

    public Statistics getStatistic() {
        return statisticService.getStatic();
    }

}
