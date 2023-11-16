import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.Scanner;


class DOMProcessor {
    public static void createXMLFile() {
        ArrayList<Student> students = readStudentsFromConsole();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("students");
            doc.appendChild(rootElement);

            for (Student student : students) {
                Element studentElement = doc.createElement("student");
                rootElement.appendChild(studentElement);

                Element nameElement = doc.createElement("Имя");
                nameElement.appendChild(doc.createTextNode(student.getName()));
                studentElement.appendChild(nameElement);

                Element ageElement = doc.createElement("Возраст");
                ageElement.appendChild(doc.createTextNode(String.valueOf(student.getAge())));
                studentElement.appendChild(ageElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("students.xml");
            transformer.transform(source, result);

            System.out.println("XML файл успешно создан.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Student> readStudentsFromConsole() {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество студентов: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Студент " + (i + 1));
            System.out.print("Имя: ");
            String name = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            students.add(new Student(name, age));
        }

        return students;
    }
}

