package functional_interfaces;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    static Supplier<Student> studentSupplier = () ->
            new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));

    static Supplier<List<Student>> studentListSupplier = () -> StudentDataBase.getAllStudents();

    public static void main(String[] args) {
        // Exact opposite of Consumer
        // No input returns output

        System.out.println("studentSupplier : " + studentSupplier.get());
        System.out.println("studentListSupplier : " + studentListSupplier.get());
    }
}
