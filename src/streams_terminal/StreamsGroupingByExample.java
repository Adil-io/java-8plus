package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Terminal Operations - groupingBy()
 * - groupingBy() collector is equivalent to the GROUP BY operation in SQL
 * - Used to group the elements based on a property
 * - The output of the groupingBy() is going to be a Map<K,V>
 * - There are three different versions of groupingBy()
 * -> groupingBy(classifier) - classifier determines the key and grouping logic
 * -> groupingBy(classifier, downstream) - downstream can be any type of Collector
 * -> groupingBy(classifier, supplier, downstream) - supplier is used to override the default Map factory
 */
public class StreamsGroupingByExample {

    public static void groupStudentsByGender() {
        Map<String, List<Student>> genderStudentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(genderStudentMap);
    }

    public static void groupStudentsByGender_customized() {
        Map<String, List<Student>> genderStudentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "outstanding" : "average"));
        System.out.println(genderStudentMap);
    }

    public static void main(String[] args) {
        groupStudentsByGender();
        groupStudentsByGender_customized();
    }
}
