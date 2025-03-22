package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

/**
 * Terminal Operations - summingInt(), averageInt()
 * summingInt() - this collector returns the sum as a result.
 * averageInt() - this collector returns the average as a result.
 */
public class StreamsSumAvgExample {

    public static int sum() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.summingInt(Student::getNotebooks));
    }

    public static double avg() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.averagingInt(Student::getNotebooks));
    }

    public static void main(String[] args) {
        System.out.println("sum: " + sum());
        System.out.println("avg: " + avg());
    }
}
