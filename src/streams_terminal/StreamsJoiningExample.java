package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

/**
 * Streams Terminal Operations:
 * Terminal operations collects the data .
 * Terminal operations starts the whole stream pipeline.
 * Terminal Operations:
 * forEach(), min(), max(), reduce(), collect() etc.
 * ======================================================
 * collect():
 * The collect() method takes in an input of type Collector.
 * Produces the result as per the input passed to the collect() method.
 * --------------------------------------------------------------------
 * joining():
 * joining() Collector performs the String concatenation on the elements in the stream.
 * joining() has three different overloaded versions
 * - joining() -> simple concat.
 * - joining(delimiter) -> concat with delimiter for each element in stream.
 * - joining(delimiter, prefix, suffix) -> concat with delimiter for each element in stream
 * and a prefix and suffix string.
 */
public class StreamsJoiningExample {

    public static String joining1() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }

    public static String joining2() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }

    public static String joining3() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-", "(", ")"));
    }

    public static void main(String[] args) {
        System.out.println("joining1: " + joining1());
        System.out.println("joining2: " + joining2());
        System.out.println("joining3: " + joining3());
    }
}
