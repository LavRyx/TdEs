import java.util.*;

class AverageGradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getAverageGrade() < student2.getAverageGrade()) {
            return -1;
        } else if (student1.getAverageGrade() > student2.getAverageGrade()) {
            return 1;
        } else {
            return 0;
        }
    }
}