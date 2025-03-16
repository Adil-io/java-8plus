package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExample {

    public static List<String> namesList() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                // Student as input -> String (Student Name) as output
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String> -> uppercase operation on each input
                .collect(Collectors.toList()); // List<String>
    }

    public static Set<String> namesSet() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                // Student as input -> String (Student Name) as output
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String> -> uppercase operation on each input
                .collect(Collectors.toSet()); // List<String>
    }

    public static void main(String[] args) {
        System.out.println(namesList());
        System.out.println(namesSet());
    }
}
