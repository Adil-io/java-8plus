package numeric_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Numeric Streams
 * Represents the primitive values in a Stream.
 * - IntStream
 * - LongStream
 * - DoubleStream
 */
public class NumericStreamsExample {

    public static int sumOfNNumbers(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (x, y) -> x + y); // Unboxing to convert the Integer to int
    }

    public static int sumOfNNumbersIntStream() {
        return IntStream.rangeClosed(1, 6) // 1, 2, 3, 4, 5, 6
                // int is passed one-by-one -> 1, 2, 3, 4, 5, 6
                // result is then accumulated -> sum (in this case)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("sumOfNNumbers: " + sumOfNNumbers(integerList));

        System.out.println("sumOfNNumbersIntStream: " + sumOfNNumbersIntStream());
    }
}
