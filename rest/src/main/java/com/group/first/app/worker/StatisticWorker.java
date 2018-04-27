package com.group.first.app.worker;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.group.first.app.configuration.Loading;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by DMikhailov on 31.01.2018.
 */

@Component
public class StatisticWorker extends AbstractWorker {

    private static final Logger log = LoggerFactory.getLogger(StatisticWorker.class);

    @Autowired
    protected Loading loading;

    protected ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2, new ThreadFactoryBuilder().setNameFormat("compute-statistic-%d").build());

    /**
     * кол-во полностью успешно обработанных запросов;
     * - кол-во запросов, обработанных с бизнес-ошибкой;
     * - кол-во запросов , обработанных с системной ошибкой (с возможностью группировки по типу системной ошибки);
     * кол-во успешно импортированных/обновленных/удаленных объектов (количество обработанных объектов);
     * интенсивность создания/обновления/удаления объектов (операций с объектами);
     * среднее время обработки объекта (с возможностью детализации по этапам обработки: ожидание в очереди, интеграционный сервис, фасад);
     * количество запросов в очереди;
     */
    @Override
    public void run() {
        log.info("Run task for compute data.");
    }

    @PreDestroy
    protected void destroy(){
        executorService.shutdownNow();
    }
}
