package concurrency.divider;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.Arrays;

public class DividerMethods {
static void compareAndDisplay(String message, AtomicInteger counter, IntPredicate result, final CyclicBarrier Barrier) {
        if (result.test(counter.get()))
            System.out.println(message);
        try {
            Barrier.await();
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
