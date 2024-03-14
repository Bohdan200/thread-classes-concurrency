package primitive.timing;

import primitive.timing.threads.FirstThread;
import primitive.timing.threads.SecondThread;
import primitive.timing.threads.Timer;

import java.util.Scanner;

public class ProgramTimingTests {
    public static void main(String[] args) {
        Timer timer = new Timer();
        FirstThread threadOne = new FirstThread(timer);
        SecondThread threadSecond = new SecondThread(timer);

        Scanner scanner = new Scanner(System.in);

        while (!Thread.currentThread().isInterrupted()) {
            String command = scanner.nextLine();

            switch (command) {
                case "start":
                    System.out.println("The program has commenced its operation.");
                    threadOne.start();
                    threadSecond.start();
                    break;

                case "w":
                    System.out.println("The program is currently on hold. To resume operations, input the 'n' command.");
                    threadSecond.setRunning(false);
                    break;

                case "n":
                    System.out.println("The program continued with its execution.");
                    threadSecond.setRunning(true);
                    break;

                case "0":
                    System.out.println("The program has finished its execution!");
                    threadOne.interrupt();
                    threadSecond.interrupt();
                    Thread.currentThread().interrupt();
                    break;

                default:  System.out.println("Invalid command, only the following commands are recognized: 'start' (to initiate), 'w' (to wait), 'n' (to continue), and '0' (to exit).");
            }
        }
    }
}
