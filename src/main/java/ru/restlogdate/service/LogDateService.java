package ru.restlogdate.service;

import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;

import java.time.LocalDateTime;
import java.util.Random;

public class LogDateService {


    public LogDate create() {
        final Random random = new Random(47);
        LogDate logDate = new LogDate();
        logDate.setGUID(random.nextInt(Integer.MAX_VALUE));
        logDate.setLogStatus(LogStatus.created);
        logDate.setDateTime(LocalDateTime.now());

        return logDate;
    }

    public LogDate get(int id) {
        //заглужка, обращение к базе, получение LogDate
        LogDate logDate = new LogDate();
        logDate.setGUID(45);
        //
        logDate.setLogStatus(LogStatus.created);
        logDate.setDateTime(LocalDateTime.now());
        return logDate;
    }

    public void update(int id, LogStatus status) {
        //заглужка, обращение к базе, получение LogDate
        LogDate logDate = new LogDate();
        logDate.setGUID(id);
        //

        logDate.setDateTime(LocalDateTime.now());
        logDate.setLogStatus(status);
        System.out.println(status);
        //сохранение в базе
    }
}
