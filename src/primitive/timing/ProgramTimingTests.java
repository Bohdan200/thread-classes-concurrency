package primitive.timing;

import primitive.timing.threads.CurrentTimeThread;

import java.util.Scanner;

public class ProgramTimingTests {
    public static void main(String[] args) {
        CurrentTimeThread thread = new CurrentTimeThread();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();

            switch (command) {
                case "start":
                    System.out.println("The program has commenced its operation.");
                    thread.setStart((int) System.currentTimeMillis());
                    thread.start();
                    break;

                case "w":
                    System.out.println("The program is currently on hold. To resume operations, input the 'n' command.");
                    thread.setRunning(false);
                    break;

                case "n":
                    System.out.println("The program continued with its execution.");
                    thread.setRunning(true);
                    break;

                case "0":
                    System.out.println("The program has finished its execution!");
                    System.exit(0);
                    break;

                default:  System.out.println("Invalid command, only the following commands are recognized: 'start' (to initiate), 'w' (to wait), 'n' (to continue), and '0' (to exit).");
            }
        }
    }
}
