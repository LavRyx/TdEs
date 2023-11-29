package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Создание списка студентов и ввод данных с клавиатуры
            List<Student> students = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите информацию о студентах (для завершения введите exit):");

            while (true) {
                System.out.print("Имя студента: ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Возраст: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.print("Курс: ");
                String course = scanner.nextLine();

                Student student = new Student(name, age, course);
                students.add(student);
            }

            // Создание XML-файла (students.xml) с помощью JAXB
            File xmlFile = new File("students.xml");
            JAXBContext context = JAXBContext.newInstance(Student.class, StudentListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new StudentListWrapper(students), xmlFile);

            System.out.println("Файл students.xml создан успешно.");

            // Чтение XML-файла и создание списка студентов
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StudentListWrapper wrapper = (StudentListWrapper) unmarshaller.unmarshal(xmlFile);
            List<Student> readStudents = wrapper.getStudents();

            // Вывод списка студентов
            System.out.println("Список студентов из файла:");
            for (Student student : readStudents) {
                System.out.println(student);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}