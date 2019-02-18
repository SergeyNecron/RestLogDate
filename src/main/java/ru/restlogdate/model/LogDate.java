package ru.restlogdate.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

@XmlRootElement(name = "LogDate")
public class LogDate implements Serializable {

    private int GUID;
    private LocalDateTime dateTime;
    private LogStatus logStatus;

    private final Random random = new Random(47);
    public LogDate() {
        GUID = random.nextInt(Integer.MAX_VALUE);
        dateTime = LocalDateTime.now();
        logStatus = LogStatus.created;
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

    public LogStatus getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(LogStatus logStatus) {
        this.logStatus = logStatus;
    }
}
