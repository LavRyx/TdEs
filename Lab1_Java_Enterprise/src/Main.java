import java.util.Scanner;

/**
 * Мейн класс
 */
public class Main {
    public static void main(String[] args) {
        FileWriterUtility utility = new FileWriterUtility();
        FileWriterThread writerThread = new FileWriterThread(utility);
        FileCheckerThread checkerThread = new FileCheckerThread(utility);

        writerThread.start();
        checkerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                utility.stopThreads(writerThread, checkerThread);
                break;
            }
        }

        scanner.close();
    }
}