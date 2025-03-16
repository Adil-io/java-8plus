package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    public static List<String> getStudentActivities() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List>
                .flatMap(List::stream) // Stream<String>
                .collect(Collectors.toList()); // List<String>
    }

    public static void main(String[] args) {
        System.out.println("Print Student activities: " + getStudentActivities());
    }
}
