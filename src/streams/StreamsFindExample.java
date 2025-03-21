package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

/**
 * Streams API: findFirst() and findAny()
 * Used to find an element in the stream.
 * Both the functions returns the result of type Optional.
 * 1. findFirst(): Returns first element in the stream.
 * 2. findAny(): Returns the first encountered element in the stream.
 * Note: There is a slight difference between the two, which is covered in Parallel streams.
 */
public class StreamsFindExample {

    public static Optional<Student> findAnyStudent() {
        return StudentDataBase.getAllStudents().stream()
                // Student passed in stream in order -> Adam, Jenny, Emily
                .filter(student -> student.getGpa() >= 3.9)
                // Since Emily satisfies the filter it's the first occurrence in the stream & hence returned
                .findAny();
    }

    public static Optional<Student> findFirstStudent() {
        return StudentDataBase.getAllStudents().stream()
                // Student passed in stream in order -> Adam, Jenny, Emily
                .filter(student -> student.getGpa() >= 3.9)
                // Since Emily satisfies the filter it's the first element in the stream & hence returned
                .findFirst();
    }

    public static void main(String[] args) {
        Optional<Student> optionalStudent = findAnyStudent();
        if (optionalStudent.isPresent()) {
            System.out.println("findAnyStudent: " + optionalStudent.get());
        } else {
            System.out.println("Student Not Found!");
        }

        optionalStudent = findFirstStudent();
        if (optionalStudent.isPresent()) {
            System.out.println("findFirstStudent: " + optionalStudent.get());
        } else {
            System.out.println("Student Not Found!");
        }
    }
}
