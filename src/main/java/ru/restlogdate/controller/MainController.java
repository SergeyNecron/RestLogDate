package ru.restlogdate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.restlogdate.Utilities;
import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;
import ru.restlogdate.service.LogDateService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RestController
public class MainController {

    public MainController() {
    }

    //    @POST
    @GET
    @Path("/")
    @Produces("application/xml")
    // @ResponseStatus(value = HttpStatus.OK)
    //@RequestMapping(value = "/", method = RequestMethod.GET)

    //   public int getLogDate () throws InterruptedException {
    public LogDate getLogDate() {

        LogDateService logDateService = new LogDateService();
        LogDate logDate = logDateService.create();
        int id = logDate.getGUID();
        HttpStatus.valueOf(202);                        // не возвращает статус
        logDateService.update(id, LogStatus.running);
        Utilities.DeferMetod(() -> logDateService.update(id, LogStatus.finished), 120);

        //     return id;
        return logDate;//не получается выводить только одно id
    }

    @GET
    @Path("/id")
    @Produces("application/xml")
    public LogDate getLogDateID() {
        // public LogStatus getLogDateID() {
        int id = 45; //получить id из запроса
        LogDateService logDateService = new LogDateService();
        LogDate logDate = logDateService.get(id);
        if (logDate == null) HttpStatus.valueOf(404);
        HttpStatus.valueOf(200);
        return logDate;
        //  return logDate.getLogStatus();
    }
}
