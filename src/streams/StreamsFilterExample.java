package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;

public class StreamsFilterExample {

    public static List<Student> filterStudents() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter(student -> student.getGender().equalsIgnoreCase("female")) // Stream<Student>
                // Filters and sends only the students whose gender is female
                .filter(student -> student.getGpa() >= 3.9) // Stream<Student>
                // Filters and sends only the students whose GPA is >= 3.9
                .toList();
    }

    public static void main(String[] args) {
        filterStudents().forEach(System.out::println);
    }
}
