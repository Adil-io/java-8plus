package numeric_streams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Numeric Stream Ranges:
 * IntStream:
 * IntStream.range(1, 50) -> Returns an IntStream of 49 elements from 1 to 49.
 * IntStream.rangeClosed(1, 50) -> Returns an IntStream of 50 elements from 1 to 50.
 * LongStream:
 * LongStream.range(1, 50) -> Returns a LongStream of 49 elements from 1 to 49.
 * LongStream.rangeClosed(1, 50) -> Returns a LongStream of 50 elements from 1 to 50.
 * DoubleStream
 * It does not support the range() and rangeClosed().
 */
public class NumericStreamsRangesExample {

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 50);
        System.out.println("intStream range count: " + intStream.count());
        // Invalid as Streams can only be iterated once.
        // intStream.forEach(value -> System.out.println(value + ","));
        IntStream.range(1, 50).forEach(value -> System.out.print(value + ","));
        System.out.println();
        intStream = IntStream.rangeClosed(1, 50);
        System.out.println("intStream rangeClosed count: " + intStream.count());
        IntStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ","));
        System.out.println();

        LongStream longStream = LongStream.range(1, 50);
        System.out.println("longStream range count: " + longStream.count());
        // Invalid as Streams can only be iterated once.
        // longStream.forEach(value -> System.out.println(value + ","));
        LongStream.range(1, 50).forEach(value -> System.out.print(value + ","));
        System.out.println();
        longStream = LongStream.rangeClosed(1, 50);
        System.out.println("longStream rangeClosed count: " + longStream.count());
        LongStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ","));
        System.out.println();

        System.out.println("Double Stream (does not support range & rangeClosed):");
        IntStream.rangeClosed(1, 50).asDoubleStream().forEach(value -> System.out.print(value + ","));
    }
}
