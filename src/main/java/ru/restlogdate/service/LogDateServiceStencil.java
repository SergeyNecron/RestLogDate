package ru.restlogdate.service;

import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;

public interface LogDateServiceStencil {
    LogDate create();

    LogDate get(int id);

    void update(LogDate logDate, LogStatus status);
}
