package streams;

import data.StudentDataBase;

/**
 * Streams API: anyMatch(), allMatch(), noneMatch()
 * All these functions takes in a Predicate as an input and returns a Boolean as an output.
 * 1. anyMatch(): Returns true if any one of the element matches the Predicate, otherwise false.
 * 2. allMatch(): Returns true if all the element in the stream matches the Predicate, otherwise false.
 * 3. noneMatch(): Just opposite to allMatch(), Returns true if none of the element in the stream matches the Predicate, otherwise false.
 */
public class StreamsMatchExample {

    public static boolean allMatch() {
        return StudentDataBase.getAllStudents().stream()
                .allMatch(s -> s.getGpa() >= 3.5);
    }

    public static boolean anyMatch() {
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(s -> s.getGpa() >= 4.0);
    }

    public static boolean noneMatch() {
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(s -> s.getGpa() >= 4.1);
    }

    public static void main(String[] args) {
        System.out.println("allMatch: " + allMatch());
        System.out.println("anyMatch: " + anyMatch());
        System.out.println("noneMatch: " + noneMatch());
    }
}
