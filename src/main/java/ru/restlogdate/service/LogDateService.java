package ru.restlogdate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;
import ru.restlogdate.repository.LogDateRepositoryStencil;

import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class LogDateService implements LogDateServiceStencil {

    @PersistenceContext
    private LogDateRepositoryStencil logDateRepository;

    @Autowired
    public void setLogDateRepository(LogDateRepositoryStencil logDateRepository) {
        this.logDateRepository = logDateRepository;
    }

    @Override
    @Transactional
    public LogDate create() {
        final Random random = new Random(47);
        LogDate logDate = new LogDate();
        logDate.setGUID(random.nextInt(Integer.MAX_VALUE));
        logDate.setLogStatus(LogStatus.created);
        logDate.setDateTime(LocalDateTime.now());
        logDateRepository.addLogDate(logDate);
        return logDate;
    }

    @Override
    @Transactional
    public LogDate get(int id) {
        LogDate logDate = logDateRepository.getLogDate(id);
        logDate.setLogStatus(LogStatus.created);
        logDate.setDateTime(LocalDateTime.now());
        logDateRepository.updateLogDate(logDate);
        return logDate;
    }

    @Override
    @Transactional
    public void update(int id, LogStatus status) {
        LogDate logDate = logDateRepository.getLogDate(id);
        logDate.setDateTime(LocalDateTime.now());
        logDate.setLogStatus(status);
        System.out.println(status);
        logDateRepository.updateLogDate(logDate);
    }
}
