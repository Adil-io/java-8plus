package functional_interfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    private static final Consumer<Student> c2 = (student) -> System.out.println(student);
    private static final Consumer<Student> c3 = (student -> System.out.print(student.getName()));
    private static final Consumer<Student> c4 = (student -> System.out.println(student.getActivities()));
    private static final List<Student> studentList = StudentDataBase.getAllStudents();

    public static void printStudents() {
        System.out.println("printStudents");
        studentList.forEach(c2);
    }

    public static void printNameAndActivities() {
        System.out.println("printNameAndActivities");
        studentList.forEach(c3.andThen(c4)); // Consumer Chaining
    }

    public static void printNameAndActivitiesUsingCondition() {
        System.out.println("printNameAndActivitiesUsingCondition");
        studentList.forEach(student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
                c3.andThen(c4).accept(student); // Consumer Chaining
            }
        });
    }

    public static void main(String[] args) {
        // Exact opposite of Supplier
        // Takes input returns nothing

        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("java8");

        printStudents();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();
    }
}
