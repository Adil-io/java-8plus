package numeric_streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Numeric Streams -> mapToObj(), mapToInt(), mapToLong(), mapToDouble()
 * mapToObj -> Converts each element of numeric stream to some Object.
 * mapToInt -> Converts a numeric stream to Int Stream.
 * mapToLong -> Converts a numeric stream to Long Stream.
 * mapToDouble -> Converts a numeric stream to Double Stream.
 */
public class NumericStreamsMapExample {

    public static List<Integer> mapToObj() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj(i -> Integer.valueOf(i))
                .collect(Collectors.toList());
    }

    public static Long mapToLong() {
        return IntStream.rangeClosed(1, 5)// IntStream
                // i is passed from IntStream
                .mapToLong(i -> i) // Convert IntStream to LongStream
                .sum();
    }

    public static Double mapToDouble() {
        return IntStream.rangeClosed(1, 5)// IntStream
                // i is passed from IntStream
                .mapToDouble(i -> i) // Convert IntStream to DoubleStream
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("mapToObj: " + mapToObj());
        System.out.println("mapToLong: " + mapToLong());
        System.out.println("mapToDouble: " + mapToDouble());
    }
}
