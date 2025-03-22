package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Terminal Operations - partitioningBy()
 * - partitioningBy() collector is also a kind of groupingBy().
 * - partitioningBy() accepts a predicate as an input.
 * - Return type of the collector is going to be Map<K,V>
 * -> The key of the return type is going to be a Boolean.
 * - There are two different versions of partitioningBy()
 * -> partitioningBy(predicate) - predicate determines the key and is either true or false
 * -> partitioningBy(predicate, downstream) - downstream determines the value and can be any type of Collector
 * This basically partitions the stream of elements in true or false buckets
 */
public class StreamsPartitioningByExample {

    private static final Predicate<Student> studentGpaPredicate = s -> s.getGpa() >= 3.8;

    public static void partitioningBy_OneArg() {
        System.out.println("====================");
        Map<Boolean, List<Student>> booleanListMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(studentGpaPredicate));
        System.out.println("booleanListMap: " + booleanListMap);
    }

    public static void partitioningBy_TwoArgs() {
        System.out.println("====================");
        Map<Boolean, Set<Student>> booleanSetMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(
                        studentGpaPredicate, // key
                        Collectors.toSet() // value
                ));
        System.out.println("booleanSetMap: " + booleanSetMap);
    }

    public static void main(String[] args) {
        partitioningBy_OneArg();
        partitioningBy_TwoArgs();
    }
}
