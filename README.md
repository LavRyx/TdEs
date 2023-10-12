# Лабораторные по предмету "Технологии разработки Enterprise решений"
3 курс 1 семестр

## Лабораторная работа №1 "Потоки"
Напишите программу, запускающую 2 независимых потока. Первый поток
выполняет запись в файл currentdata.txt строки «the first thread writes the time:»
посимвольно, по одному символу в 200 миллисекунд (или реже). Затем записывает
в файл время записи строки. После чего поток спит 1 секунду. Для определения
даты и времени использовать класс java.util.Calendar. Второй поток каждые 15
секунд проверяет размер файла currentdata.txt и если этот размер превысил 200
байт, то сохраняет файл под уникальным именем и обнуляет файл currentdata.txt.
Уникальное имя файла должно содержать дату и время его создания. Программа
должна содержать 4 класса: первый класс реализует первый поток, второй класс
реализует второй поток, третий класс содержит метод main, из которого
запускаются оба потока, четвертый класс содержит методы, используемые 1 и 2
классами. В третьем классе должна быть реализована возможность завершения
обоих потоков по требованию пользователя. Организовать синхронизацию
потоков: переименование не должно выполняться при записи в файл первым
потоком.
При работе с файлами организовать обработку исключительных ситуаций.
Для реализации некоторых операций с файлами используйте классы java.io.File и
java.io.FileOutputStream().
Создайте документацию по проекту в формате html с помощью javaDoc.

## Лабораторная №2 Коллекции в Java
Ввести с клавиатуры 10 фамилий, внести их в ArrayList. Отсортировать их и вывести на экран. Проверить сколько раз в списке встречается каждая фамилия и вывести на экран. Удалить все повторяющиеся фамилии и оставить только в единственном виде.
Проверить скорости работы ArrayList или LinkedList для операций: добавление элемента в конец списка, удаление элемента с начала списка. Для проверки используйте 1000000 операций для добавления и 1000 для удаления. 
Отсортировать коллекцию студентов по среднему балу и вывести их фамилии и средний бал в порядке возрастания среднего бала. Использовать класс TreeMap. При этом создать класс Student implements Comparable и в нем реализовать метод compareTo.
Реализовать возможность сортировки студентов по фамилии, среднему балу и возрасту с помощью интерфейса Comparator.
Создать коллекцию студентов HashSet, в которой не будет храниться двух студентов с одинаковыми фамилиями. Для этого в классе Student переопределить методы hashCode() и equals().

