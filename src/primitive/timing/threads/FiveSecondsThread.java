package primitive.timing.threads;

public class FiveSecondsThread extends Thread {

    @Override
    public void run() {
        System.out.println("It has been next five seconds.");

        try {
            Thread.sleep(1100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
