package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduceExample {

    public static int performMultiplication(List<Integer> integerList) {
        // reduce is a terminal function
        return integerList.stream()
                // int passed in stream in order 1, 3, 5, 7
                // a = 1 (first parameter as initial value), b = 1 (from stream) -> result 1 is returned
                // a = 1 (previous result), b = 3 (from stream) -> result 3 is returned
                // a = 3 (previous result), b = 5 (from stream) -> result 15 is returned
                // a = 15 (previous result), b = 7 (from stream) -> result 105 is returned
                .reduce(1, (a, b) -> a * b);
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {
        // reduce is a terminal function
        // without identity reduce returns an Optional object
        return integerList.stream()
                // int passed in stream in order 1, 3, 5, 7
                // a = 1 (from stream), b = 3 (from stream) -> result 3 is returned
                // a = 3 (previous result), b = 5 (from stream) -> result 15 is returned
                // a = 15 (previous result), b = 7 (from stream) -> result 105 is returned
                .reduce((a, b) -> a * b);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 3, 5, 7);
        System.out.println("performMultiplication: " + performMultiplication(integerList));
        Optional<Integer> optionalInteger = performMultiplicationWithoutIdentity(integerList);
        System.out.println("performMultiplicationWithoutIdentity isPresent: " + optionalInteger.isPresent());
        if (optionalInteger.isPresent()) {
            System.out.println("performMultiplicationWithoutIdentity: " + optionalInteger.get());
        }
    }
}
