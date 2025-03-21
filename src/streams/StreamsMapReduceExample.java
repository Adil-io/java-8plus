package streams;

import data.Student;
import data.StudentDataBase;

public class StreamsMapReduceExample {

    private static int noOfNoteBooks() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter((s) -> s.getGradeLevel() >= 3) // Stream<Student>
                .filter((s) -> s.getGender().equals("female")) // Stream<Student>
                .map(Student::getNotebooks) // Stream<Integer>
                // .reduce(0, (a, b) -> a + b)
                .reduce(0, Integer::sum); // int sum of all notebooks with filters provided
    }

    public static void main(String[] args) {
        System.out.println("noOfNoteBooks: " + noOfNoteBooks());
    }
}
