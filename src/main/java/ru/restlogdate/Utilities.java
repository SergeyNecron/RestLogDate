package ru.restlogdate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Utilities {
    public static void DeferMetod(Runnable runnable, int sec) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.schedule(runnable, sec, TimeUnit.SECONDS);
    }
}
