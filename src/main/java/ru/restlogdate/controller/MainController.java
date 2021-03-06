package ru.restlogdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;
import ru.restlogdate.service.LogDateServiceStencil;

import static ru.restlogdate.Utilities.DeferMetod;
import static ru.restlogdate.Utilities.setRun;

@RestController
public class MainController {

    private LogDateServiceStencil logDateService;

    @Autowired
    public void setLogDateService(LogDateServiceStencil logDateService) {
        this.logDateService = logDateService;
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<String> createLogDate() {
        LogDate logDate = logDateService.create();
        DeferMetod(() -> {
            logDateService.update(logDate, LogStatus.running);
            setRun();
        }, 1);
        //в задании сначала возвращаем GUID, потом меняем статус на running
        DeferMetod(() -> {
            logDateService.update(logDate, LogStatus.finished);
            setRun();
        }, 120);
        String rezult = "GUID:\n" + logDate.getGUID() + "\n";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("", rezult);
        return new ResponseEntity<>(String.valueOf(logDate.getGUID()), responseHeaders, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/task/{guid}", method = RequestMethod.GET)
    public ResponseEntity<String> getLogDate(@PathVariable(value = "guid") int guid) {

        LogDate logDate = logDateService.get(guid);
        HttpHeaders responseHeaders = new HttpHeaders();
        String rezult;
        if (logDate == null) {
            rezult = "NO SUCH task: " + guid;
            responseHeaders.set("", rezult);
            return new ResponseEntity<>(rezult, responseHeaders, HttpStatus.NOT_FOUND);
        }
        rezult = logDate.toString();
        responseHeaders.set("", rezult);
        return new ResponseEntity<>(rezult, responseHeaders, HttpStatus.OK);
    }
}
