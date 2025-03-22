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
        System.out.println("====================");
        Map<String, List<Student>> genderStudentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println("genderStudentMap: " + genderStudentMap);
    }

    public static void groupStudentsByGender_customized() {
        System.out.println("====================");
        Map<String, List<Student>> genderStudentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
        System.out.println("genderStudentMap: " + genderStudentMap);
    }

    public static void twoLevelGrouping_1() {
        System.out.println("====================");
        Map<Integer, Map<String, List<Student>>> gradeStudentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
        System.out.println("gradeStudentMap: " + gradeStudentMap);
    }

    public static void twoLevelGrouping_2() {
        System.out.println("====================");
        Map<String, Integer> nameNotebooksMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getNotebooks)));
        System.out.println("nameNotebooksMap: " + nameNotebooksMap);
    }

    public static void main(String[] args) {
        groupStudentsByGender();
        groupStudentsByGender_customized();
        twoLevelGrouping_1();
        twoLevelGrouping_2();
    }
}
