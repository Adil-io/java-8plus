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
                .filter(studentGradePredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        // No intermediate operations will be invoked until the terminal operation is invoked

        System.out.println(studentsMap);
    }

}
