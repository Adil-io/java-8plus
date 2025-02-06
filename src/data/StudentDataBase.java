package data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentDataBase {

    public static Supplier<Student> studentSupplier = () ->
            new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));


    public static List<Student> getAllStudents() {
        return List.of(
                // 2nd grade students
                new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball")),
                new Student("Jenny", 2, 3.8, "female", Arrays.asList("swimming", "gymnastics", "soccer")),
                // 3rd grade students
                new Student("Emily", 3, 4.0, "female", Arrays.asList("swimming", "gymnastics", "aerobics")),
                new Student("Dave", 3, 3.9, "male", Arrays.asList("swimming", "gymnastics", "soccer")),
                // 4th grade students
                new Student("Sophia", 4, 3.5, "female", Arrays.asList("swimming", "dancing", "football")),
                new Student("James", 4, 3.9, "male", Arrays.asList("swimming", "basketball", "baseball", "football"))
        );
    }
}
