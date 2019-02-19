package ru.restlogdate.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;

@XmlRootElement(name = "LogDate")
public class LogDate implements Serializable {

    private int GUID;
    private LocalDateTime dateTime;
    private LogStatus logStatus;


    public LogDate() {
    }

    public int getGUID() {
        return GUID;
    }

    public void setGUID(int GUID) {
        this.GUID = GUID;
    }

    public String getDateTime() {
        return dateTime.toString();
    }

    public void setDateTime(String dateTime) {
        this.dateTime = LocalDateTime.now();
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LogStatus getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(LogStatus logStatus) {
        this.logStatus = logStatus;
    }
}
