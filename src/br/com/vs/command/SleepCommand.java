package br.com.vs.command;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

/**
 * Created by vsaueia on 10/30/16.
 */
public class SleepCommand implements Command {
    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0L;
    private LocalTime startTime;
    private boolean started = false;

    public SleepCommand(long milliseconds, ActiveObjectEngine engine, Command wakeupCommand) {
        this.sleepTime = milliseconds;
        this.engine = engine;
        this.wakeupCommand = wakeupCommand;
    }

    public void execute() {
        LocalTime currentTime = LocalTime.now();
        if (!started) {
            started = true;
            startTime = currentTime;
            engine.add(this);
        } else {
            long elapsedTime = Duration.between(startTime, currentTime).getSeconds() * 1000;
            if (elapsedTime < sleepTime) {
                engine.add(this);
            } else {
                engine.add(wakeupCommand);
            }
        }
    }
}
