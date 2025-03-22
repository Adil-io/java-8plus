package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Terminal Operations - minBy(), maxBy()
 * Comparator as an input parameter and Optional as an output
 * maxBy() - This collector is used in conjunction with comparator. Returns the max element
 * based on the property passed to the comparator.
 * minBy() - This collector is used in conjunction with comparator. Returns the min element
 * based on the property passed to the comparator.
 */
public class StreamsMinMaxByExample {

    public static Optional<Student> minBy() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> min() {
        return StudentDataBase.getAllStudents().stream()
                .min(Comparator.comparingDouble(Student::getGpa));
    }

    public static Optional<Student> maxBy() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> max() {
        return StudentDataBase.getAllStudents().stream()
                .max(Comparator.comparingDouble(Student::getGpa));
    }

    public static void main(String[] args) {
        System.out.println("minBy: " + minBy());
        System.out.println("min: " + min());
        System.out.println("maxBy: " + maxBy());
        System.out.println("max: " + max());
    }
}
