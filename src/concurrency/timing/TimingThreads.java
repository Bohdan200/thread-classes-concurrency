package concurrency.timing;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class TimingThreads {
    private static volatile AtomicLong time;
    public static volatile boolean exit = false;

    public void setExit(boolean exit) {
        TimingThreads.exit = exit;
    }

    public void getСurrentTime() {
        ScheduledExecutorService timers = Executors.newScheduledThreadPool(2);

        time = new AtomicLong(0);

        timers.scheduleAtFixedRate(
                () -> {
                    time.incrementAndGet();
                    System.out.println("Program execution time since initiation = " + time + " s");
                },
                1,
                1,
                TimeUnit.SECONDS
        );

        timers.scheduleAtFixedRate(
                () -> {
                    System.out.println("It has been next five seconds.");
                },
                5,
                5,
                TimeUnit.SECONDS
        );

        if (exit) {
            timers.shutdownNow();
        }
    }
}
