package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Terminal Operations - mapping()
 * mapping() collector applies a transformation function first and then collects the data
 * in a collection (could be any type of collection)
 */
public class StreamsMappingExample {

    public static void main(String[] args) {
        List<String> namesList = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));
        System.out.println("namesList: " + namesList);

        Set<String> namesSet = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
        System.out.println("namesSet: " + namesSet);

        Map<String, Double> namesGpaMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.toMap(Student::getName, Student::getGpa));
        System.out.println("namesGpaMap: " + namesGpaMap);
    }
}
