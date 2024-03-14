package concurrency.timing;

import java.util.Scanner;

public class ProgramTimingTests {
    public static void main(String[] args) {
        TimingThreads thread = new TimingThreads();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();

            switch (command) {
                case "start":
                    System.out.println("The program has commenced its operation.");
                    thread.getСurrentTime();
                    break;

                case "0":
                    System.out.println("The program has finished its execution!");
                    thread.setExit(true);
                    System.exit(1);
                    break;

                default:  System.out.println("Invalid command, only 'start' and '0' (for exit) commands are recognized.");
            }
        }
    }
}
