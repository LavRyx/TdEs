import java.util.*;


class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getAge(), student2.getAge());
    }
}
