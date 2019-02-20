package ru.restlogdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.restlogdate.Utilities;
import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;
import ru.restlogdate.service.LogDateService;
import ru.restlogdate.service.LogDateServiceStencil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RestController
public class MainController {

    private LogDateServiceStencil logDateService;

    @Autowired
    public void setLogDateService(LogDateServiceStencil logDateService) {
        this.logDateService = logDateService;
    }

    //    @POST
    @GET
    @Path("/")
    @Produces("application/xml")
    // @ResponseStatus(value = HttpStatus.OK)
//    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/xml")

    //   public int getLogDate () throws InterruptedException {
    public LogDate getLogDate() {
        LogDate logDate = logDateService.create();
        int id = logDate.getGUID();
        HttpStatus.valueOf(202);                        // не возвращает статус
        logDateService.update(id, LogStatus.running);
        Utilities.DeferMetod(() -> logDateService.update(id, LogStatus.finished), 120);
        //     return id;
        return logDate;//не получается выводить только одно id
    }

    @GET
    @Path(value = "/{id}")
    @Produces("application/xml")
    //  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/xml")
    // Ну почему, почему ты не работаешь ???!!
    public LogDate getLogDateID(@PathVariable(value = "id") int id) {
        // public LogStatus getLogDateID() {
        //  int id = 45; //получить id из запроса
        LogDateService logDateService = new LogDateService();
        LogDate logDate = logDateService.get(id);
        if (logDate == null) HttpStatus.valueOf(404);
        HttpStatus.valueOf(200);
        return logDate;
        //  return logDate.getLogStatus();
    }
}
