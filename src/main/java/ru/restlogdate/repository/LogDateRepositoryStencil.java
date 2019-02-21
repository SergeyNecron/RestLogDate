package ru.restlogdate.repository;

import ru.restlogdate.model.LogDate;

public interface LogDateRepositoryStencil {
    void addLogDate(LogDate logDate);

    void updateLogDate(LogDate logDate);

    LogDate getLogDate(int id);
}
