package functional_interfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> function = (name) -> name.toUpperCase();
    static Function<String, String> addSomeString = (name) -> name.concat("default");

    public static void main(String[] args) {
        System.out.println("Result: " + function.apply("java8"));
        // andThen executes in order -> first function then addSomeString
        System.out.println("Result of andThen is: " + function.andThen(addSomeString).apply("java8"));
        // compose executes from function params -> first addSomeString -> returns value -> then function
        System.out.println("Result of compose is: " + function.compose(addSomeString).apply("java8"));
    }
}
