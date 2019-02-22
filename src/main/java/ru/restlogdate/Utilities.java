package ru.restlogdate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Utilities {
    public static void DeferMetod(Runnable runnable, int sec) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.schedule(runnable, sec, TimeUnit.SECONDS);
    }

    public static String DateTimeFormater(Timestamp timestamp) {

        LocalDateTime date = timestamp.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        date = LocalDateTime.parse(date.format(formatter), formatter);
        return date.toString();
    }
}
