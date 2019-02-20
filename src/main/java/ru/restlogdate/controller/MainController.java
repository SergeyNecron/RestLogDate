package ru.restlogdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.restlogdate.Utilities;
import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;
import ru.restlogdate.service.LogDateServiceStencil;

@RestController
public class MainController {

    private LogDateServiceStencil logDateService;

    @Autowired
    public void setLogDateService(LogDateServiceStencil logDateService) {
        this.logDateService = logDateService;
    }

    //     @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/task", method = RequestMethod.GET)
    //   public int getLogDate ()  {
    public LogDate getLogDate() {
        LogDate logDate = logDateService.create();
        HttpStatus.valueOf(202);                        // не возвращает статус
        logDateService.update(logDate, LogStatus.running);
        Utilities.DeferMetod(() -> logDateService.update(logDate, LogStatus.finished), 120);

        return logDate;
    }

    @RequestMapping(value = "/{guid}", method = RequestMethod.GET)
    public LogDate getLogDateID(@PathVariable(value = "guid") int guid) {
        LogDate logDate = logDateService.get(guid);
        if (logDate == null) HttpStatus.valueOf(404);
        HttpStatus.valueOf(200);
        return logDate;
        //  return logDate.getLogStatus();
    }
}
