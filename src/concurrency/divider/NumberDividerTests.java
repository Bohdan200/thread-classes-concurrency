package concurrency.divider;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberDividerTests {
    public static void main(String[] args) {
        DividerThreads.divide(new AtomicInteger(90));
    }
}
