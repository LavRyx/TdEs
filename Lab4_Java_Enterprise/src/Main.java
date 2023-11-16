import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("����:");
            System.out.println("1. ������� XML ���� � �������������� DOM");
            System.out.println("2. ��������� XML ���� � ������� ������ ��������� � �������������� SAX");
            System.out.println("0. �����");

            System.out.print("�������� ��������: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> DOMProcessor.createXMLFile();
                case 2 -> SAXProcessor.readXMLFile();
                case 0 -> {
                    System.out.println("����� �� ���������.");
                    System.exit(0);
                }
                default -> System.out.println("�������� �����. ���������� ��� ���.");
            }
        }
    }
}

