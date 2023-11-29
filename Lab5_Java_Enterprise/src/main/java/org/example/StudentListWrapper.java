package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class StudentListWrapper {

    private List<Student> students;

    public StudentListWrapper() {}

    public StudentListWrapper(List<Student> students) {
        this.students = students;
    }

    @XmlElement(name = "student")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}