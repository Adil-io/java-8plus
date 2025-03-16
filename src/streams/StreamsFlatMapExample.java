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
                .distinct() // Stream<String> -> distinct function performed
                .sorted() // Stream<String> -> sorts input in the natural order(a - z)
                .collect(Collectors.toList()); // List<String>
    }

    public static Long getStudentActivitiesCount() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List>
                .flatMap(List::stream) // Stream<String>
                .distinct() // Stream<String> -> distinct function performed
                .count(); // Long
    }

    public static void main(String[] args) {
        System.out.println("Print Student activities: " + getStudentActivities());
        System.out.println("getStudentActivitiesCount: " + getStudentActivitiesCount());
    }
}
