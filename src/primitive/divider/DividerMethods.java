package primitive.divider;

import java.util.List;
import java.util.function.IntPredicate;

public class DividerMethods {
    public static void compareAndDisplay(String message, int value, IntPredicate result) {
        synchronized (Thread.currentThread()) {
            if (result.test(value))
                System.out.println(message);

            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static void notifyThreads (List<Thread>  threadList) {
        for (Thread thread : threadList) {
            synchronized (thread) {
                thread.notify();
            }
            pauseMainThread();
        }
    }

    public static void pauseMainThread() {
        synchronized (Thread.currentThread()) {
            try {
                Thread.currentThread().wait(0, 5);
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
