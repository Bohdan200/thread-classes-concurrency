package primitive.divider;

import java.util.List;

public class DividerThreads {
    public static volatile int value = 1;

    public static void divide(int maxValue) {
        List<Thread> threadList = List.of(
                new Thread(() -> {
                    while (value <= maxValue) {
                        DividerMethods.compareAndDisplay("fizz", value, (number) -> number % 3 == 0 && number % 5 != 0);
                    }
                }, "A"),
                new Thread(() -> {
                    while (value <= maxValue) {
                        DividerMethods.compareAndDisplay("buzz", value, (number) -> number % 3 != 0 && number % 5 == 0);
                    }
                }, "B"),
                new Thread(() -> {
                    while (value <= maxValue) {
                        DividerMethods.compareAndDisplay("fizzbuzz", value, (number) -> number % 3 == 0 && number % 5 == 0);
                    }
                }, "C"),
                new Thread(() -> {
                    while (value <= maxValue) {
                        DividerMethods.compareAndDisplay(value + "", value, (number) -> number % 3 != 0 && number % 5 != 0);
                    }
                }, "D")
        );

        for (Thread thread : threadList) {
            thread.start();
        }

        DividerMethods.pauseMainThread();

        while (value <= maxValue + 1) {
            synchronized (Thread.currentThread()) { value++; }

            DividerMethods.notifyThreads(threadList);
        }
    }
}
