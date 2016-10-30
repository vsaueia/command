package br.com.vs.command;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.Assert.assertTrue;

public class SleepCommandTest {
    private class WakeupCommand implements Command {
        public boolean executed = false;
        public void execute() {
            executed = true;
        }
    }

    @Test
    public void testSleep() {
        WakeupCommand wakeupCommand = new WakeupCommand();
        ActiveObjectEngine engine = new ActiveObjectEngine();
        SleepCommand sleepCommand = new SleepCommand(1000, engine, wakeupCommand);
        engine.add(sleepCommand);
        LocalTime start = LocalTime.now();
        engine.run();
        LocalTime stop = LocalTime.now();
        long sleepTime = Duration.between(start, stop).getSeconds() * 1000;
        assertTrue("SleepTime "+sleepTime+" expected > 1000", sleepTime >= 1000);
        assertTrue("SleepTime "+sleepTime+" expected < 1100", sleepTime <= 1100);
        assertTrue("wakeup executed", wakeupCommand.executed);

    }
}
