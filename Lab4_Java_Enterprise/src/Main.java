<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Создать XML файл с использованием DOM");
            System.out.println("2. Прочитать XML файл и создать список студентов с использованием SAX");
            System.out.println("0. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> DOMProcessor.createXMLFile();
                case 2 -> SAXProcessor.readXMLFile();
                case 0 -> {
                    System.out.println("Выход из программы.");
                    System.exit(0);
                }
                default -> System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}
=======
public class Main {


}
>>>>>>> 5281fef1ab90e2a1f193610e8a23689d94bdedd3
