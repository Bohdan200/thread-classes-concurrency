package primitive.timing.threads;

public class CurrentTimeThread extends Thread {
    private static volatile int start = 0;
    private static volatile int executionTime = 0;
    private volatile boolean running = true;

    public void setStart(int start) {
        CurrentTimeThread.start = start;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (true) {
            if (running) {
                executionTime = (int) (System.currentTimeMillis() - start) / 1000;
                System.out.println("Program execution time since initiation = " + executionTime + " s");

                if (executionTime != 0 && executionTime % 5 == 0) {
                    FiveSecondsThread thread = new FiveSecondsThread();
                    thread.start();
                }

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
