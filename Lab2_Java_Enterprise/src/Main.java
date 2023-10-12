import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n1. Уникальные фамилии");
            System.out.println("2. Тест List");
            System.out.println("3. Средний балл");
            System.out.println("4. Сортировки студентов");
            System.out.println("5. HashSet");
            System.out.println("6. Exit\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Ex_1();
                case 2 -> Ex_2();
                case 3 -> Ex_3();
                case 4 -> Ex_4();
                case 5 -> Ex_5();
                case 6 -> {
                    System.out.println("Выход");
                    scanner.close();
                    System.exit(0);
                }

                default -> System.out.println("Введите цифры");
            }
        }
    }



    static void Ex_1() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> surnames = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Введите фамилию " + (i + 1) + ": ");
            String surname = scanner.nextLine();
            surnames.add(surname);
        }

        Collections.sort(surnames);

        System.out.println("Отсортированные фамилии:");
        for (String surname : surnames) {
            System.out.println(surname);
        }

        System.out.println("Количество встречающихся фамилий:");
        for (String surname : surnames) {
            int count = Collections.frequency(surnames, surname);
            System.out.println(surname + ": " + count);
        }

        for (int i = 0; i < surnames.size() - 1; i++) {
            for (int j = i + 1; j < surnames.size(); j++) {
                if (surnames.get(i).equals(surnames.get(j))) {
                    surnames.remove(j);
                    j--;
                }
            }
        }

        System.out.println("Фамилии без повторений:");
        for (String surname : surnames) {
            System.out.println(surname);
        }
    }


    static void Ex_2() {
        int numOperations = 1000000;
        int numDeletions = 1000;

        // Добавление arrayList
        long startTime = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < numOperations; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        long arrayListAddTime = endTime - startTime;
        //-------------------

        // Удаление arrayList
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numDeletions; i++) {
            arrayList.remove(0);
        }
        endTime = System.currentTimeMillis();
        long arrayListRemoveTime = endTime - startTime;
        //-------------------

        // Добавление LinkedList
        startTime = System.currentTimeMillis();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < numOperations; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        long linkedListAddTime = endTime - startTime;
        //-------------------

        // Удаление LinkedList
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numDeletions; i++) {
            linkedList.remove(0);
        }
        endTime = System.currentTimeMillis();
        long linkedListRemoveTime = endTime - startTime;
        //-------------------

        System.out.println("ArrayList добавление: " + arrayListAddTime + " миллисекунд");
        System.out.println("ArrayList удаление: " + arrayListRemoveTime + " миллисекунд");
        System.out.println("LinkedList добавление: " + linkedListAddTime + " миллисекунд");
        System.out.println("LinkedList удаление: " + linkedListRemoveTime + " миллисекунд\n");

    }

    static void Ex_3() {
        TreeMap<Student, Double> studentMap = new TreeMap<>();

        studentMap.put(new Student("Иванов", 4.2, 19), 4.2);
        studentMap.put(new Student("Петров", 3.1, 20), 3.1);
        studentMap.put(new Student("Сидоров", 2.6, 23), 2.6);
        studentMap.put(new Student("Кюшин", 4.0, 20), 4.0);
        studentMap.put(new Student("Чернышов", 5.0, 20), 5.0);

        for (Student student : studentMap.keySet()) {
            System.out.println(student.getLastName() + ": " + student.getAverageGrade());
        }
    }

    static void Ex_4() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", 4.2, 19));
        students.add(new Student("Петров", 3.1, 20));
        students.add(new Student("Сидоров", 2.6, 23));
        students.add(new Student("Кюшин", 4.0, 20));
        students.add(new Student("Чернышов", 5.0, 20));

        students.sort(new LastNameComparator());
        System.out.println("Сортировка по фамилии:");
        for (Student student : students) {
            System.out.println("Фамилия: " + student.getLastName());
        }

        students.sort(new AverageGradeComparator());
        System.out.println("\nСортировка по среднему балу:");
        for (Student student : students) {
            System.out.println("Средний бал: " + student.getAverageGrade());
        }

        students.sort(new AgeComparator());
        System.out.println("\nСортировка по возрасту:");
        for (Student student : students) {
            System.out.println("Возраст: " + student.getAge());

        }
    }


    static void Ex_5() {
        HashSet<Student> studentHashSet = new HashSet<>();

        // Добавляем студентов в коллекцию HashSet
        studentHashSet.add(new Student("Иванов", 4.5, 20));
        studentHashSet.add(new Student("Петров", 3.8, 22));
        studentHashSet.add(new Student("Иванов", 4.2, 21));
        studentHashSet.add(new Student("Сидоров", 2.6, 23));
        studentHashSet.add(new Student("Кюшин", 4.0, 20));
        studentHashSet.add(new Student("Чернышов", 5.0, 20));
        studentHashSet.add(new Student("Чернышов", 4.9, 51));

        for (Student student : studentHashSet) {
            System.out.println("Фамилия: " + student.getLastName() + ", Средний бал: " + student.getAverageGrade());

        }
    }
}
