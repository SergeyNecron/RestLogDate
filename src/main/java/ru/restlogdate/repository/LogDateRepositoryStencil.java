package ru.restlogdate.repository;

import ru.restlogdate.model.LogDate;

public interface LogDateRepositoryStencil {
    void addLogDate(LogDate logDate);

    void updateLogDate(LogDate logDate);

    void removeLogDate(int id);

    LogDate getLogDate(int id);
}
