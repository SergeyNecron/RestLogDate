package ru.restlogdate.model;

import ru.restlogdate.Utilities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "logdate")
public class LogDate implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "guid")
    private int GUID;
    @Column(name = "date_time")
    private Timestamp dateTime;
    //Если хранить LocalDateTime, то session выдаёт ошибку при сохранении в базе
    @Column(name = "status")
    private String logStatus;

    public int getGUID() {
        return GUID;
    }

    public void setGUID(int GUID) {
        this.GUID = GUID;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(LogStatus logStatus) {
        this.logStatus = logStatus.toString();
    }

    @Override
    public String toString() {
        return "Task" +
                "\n GUID =" + GUID +
                "\n dateTime = " + Utilities.DateTimeFormater(dateTime) +
                "\n Status = " + logStatus +
                "\n";
    }
}
