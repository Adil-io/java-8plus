package streams_terminal;

import data.StudentDataBase;

import java.util.stream.Collectors;

/**
 * Terminal Operations - counting()
 * counting() Collector returns the total number of elements as a result.
 */
public class StreamsCountingExample {

    public static long count() {
        return StudentDataBase.getAllStudents().stream()
                .filter(s -> s.getGpa() >= 3.9)
//                .count();
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        System.out.println(count());
    }
}
