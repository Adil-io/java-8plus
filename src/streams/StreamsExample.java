package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {
        Predicate<Student> studentGradePredicate = (student -> student.getGradeLevel() >= 3);
        Predicate<Student> studentGpaPredicate = (student -> student.getGpa() >= 3.9);

        /*
        STREAMS API - Stream Pipeline
        StudentDataBase.getAllStudents().stream() -> starts stream
        .filter(studentGradePredicate) -> returns stream (intermediate operation)
        .filter(studentGpaPredicate) -> returns stream (intermediate operation)
        .collect(Collectors.toMap(Student::getName, Student::getActivities)) -> returns Map (Terminal operation)
         */
        Map<String, List<String>> studentsMap = StudentDataBase.getAllStudents().stream()
                .peek(student -> System.out.println("Student before filter: " + student))
                .filter(studentGradePredicate)
                .peek(student -> System.out.println("Student after 1st filter: " + student))
                .filter(studentGpaPredicate)
                .peek(student -> System.out.println("Student after 2nd filter: " + student))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        // No intermediate operations will be invoked until the terminal operation is invoked
        // Stream pipeline applies filter to elements one by one
        System.out.println(studentsMap);
    }

}
