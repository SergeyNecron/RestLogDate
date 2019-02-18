package ru.restlogdate.controller;

import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;

import javax.ws.rs.*;

public class RestController {
    public RestController() {
    }

    @GET
    @Path("/")
    @Produces("application/xml")
    public LogDate getLogDate() {
        LogDate logDate = new LogDate();
        logDate.setLogStatus(LogStatus.finished);
//        logDate.setDateTime(LocalDate.of(2019,11,5));
        return logDate;
    }
}
