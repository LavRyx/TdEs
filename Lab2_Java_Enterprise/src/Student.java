import java.util.*;

class Student implements Comparable<Student> {
    private final String lastName;
    private final double averageGrade;
    private final int age;

    public Student(String lastName, double averageGrade, int age) {
        this.lastName = lastName;
        this.averageGrade = averageGrade;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int compareTo(Student otherStudent) {
        if (this.averageGrade < otherStudent.averageGrade) {
            return -1;

        } else if (this.averageGrade > otherStudent.averageGrade) {
            return 1;

        } else {
            return this.lastName.compareTo(otherStudent.lastName);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }


}
