package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Terminal Operations - groupingBy()
 * - groupingBy() collector is equivalent to the GROUP BY operation in SQL
 * - Used to group the elements based on a property
 * - The output of the groupingBy() is going to be a Map<K,V>
 * - There are three different versions of groupingBy()
 * -> groupingBy(classifier) - classifier determines the key and grouping logic
 * -> groupingBy(classifier, downstream) - downstream determines the value and can be any type of Collector
 * -> groupingBy(classifier, supplier, downstream) - supplier determines the return type and is used to
 *      override the default Map factory
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

    public static void threeArgumentGroupBy() {
        System.out.println("====================");
        LinkedHashMap<String, Set<Student>> nameStudentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName, // determines key
                        LinkedHashMap::new,  // determines return type
                        Collectors.toSet())); // determines value
        System.out.println("nameStudentMap: " + nameStudentMap);
    }

    public static void calculateTopGpaPerGradeLevel() {
        System.out.println("====================");
        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparingDouble(Student::getGpa))));
        System.out.println("studentMapOptional: " + studentMapOptional);

        System.out.println("====================");
        Map<Integer, Student> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, // key
                        // Get the optional value
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Student::getGpa)),
                                Optional::get))); //value
        System.out.println("studentMap: " + studentMap);
    }

    public static void calculateLeastGpaPerGradeLevel() {
        System.out.println("====================");
        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.minBy(Comparator.comparingDouble(Student::getGpa))));
        System.out.println("studentMapOptional: " + studentMapOptional);

        System.out.println("====================");
        Map<Integer, Student> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.toMap(Student::getGradeLevel, // key
                        Function.identity(), // value
                        BinaryOperator.minBy(Comparator.comparingDouble(Student::getGpa)))); // merge function
        System.out.println("studentMap: " + studentMap);
    }

    public static void main(String[] args) {
        groupStudentsByGender();
        groupStudentsByGender_customized();
        twoLevelGrouping_1();
        twoLevelGrouping_2();
        threeArgumentGroupBy();
        calculateTopGpaPerGradeLevel();
        calculateLeastGpaPerGradeLevel();
    }
}
