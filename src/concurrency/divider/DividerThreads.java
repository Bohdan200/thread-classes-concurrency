package concurrency.divider;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DividerThreads {
    private static final AtomicInteger counter = new AtomicInteger(1);

    public static void divide(final AtomicInteger maxValue) {
        final ExecutorService executors = Executors.newFixedThreadPool(4);
        final CyclicBarrier Barrier = new CyclicBarrier(4, () -> counter.addAndGet(1));

        executors.execute(() -> {
            while (counter.get() <= maxValue.get()) {
                DividerMethods.compareAndDisplay("fizz", counter, (number) -> number % 3 == 0 && number % 5 != 0, Barrier);
            }
        });
        executors.execute(() -> {
            while (counter.get() <= maxValue.get()) {
                DividerMethods.compareAndDisplay("buzz", counter, (number) -> number % 3 != 0 && number % 5 == 0, Barrier);
            }
        });
        executors.execute(() -> {
            while (counter.get() <= maxValue.get()) {
                DividerMethods.compareAndDisplay("fizzbuzz", counter, (number) -> number % 3 == 0 && number % 5 == 0, Barrier);
            }
        });
        executors.execute(() -> {
            while (counter.get() <= maxValue.get()) {
                DividerMethods.compareAndDisplay(counter.get() + "", counter, (number) -> number % 3 != 0 && number % 5 != 0, Barrier);
            }
        });

        executors.shutdown();

        if (counter.get() > maxValue.get()) {
            Barrier.reset();
        }
    }

}
