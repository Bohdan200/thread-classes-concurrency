package primitive.timing.threads;

public class Timer {
    private int seconds = 0;

    public synchronized void add() {
        this.seconds++;
        notify();
    }

    public synchronized int last() throws InterruptedException {
        wait();
        return this.seconds;
    }
}
