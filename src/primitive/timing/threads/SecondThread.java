package primitive.timing.threads;

public class SecondThread extends Thread {
    private final Timer timer;
    private volatile boolean running = true;

    public SecondThread(Timer timer) {
        this.timer = timer;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (running) {
                try {
                    int executionTime = timer.last();
                    System.out.println("Program execution time since initiation = " + executionTime + " s");

                    if (executionTime != 0 && executionTime % 5 == 0)
                        System.out.println("It has been next five seconds.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

