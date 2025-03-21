package numeric_streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamsAggregateExample {

    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 50)
                .sum();
        System.out.println("sum: " + sum);

        OptionalInt optionalInt = IntStream.rangeClosed(1, 50)
                .max();
        System.out.println("optionalInt isPresent: " + optionalInt.isPresent());
        System.out.println("optionalInt max: " + optionalInt);
        optionalInt = IntStream.rangeClosed(0, 0).max();
        System.out.println("optionalInt count: " + optionalInt.stream().count());
        System.out.println("optionalInt isPresent: " + optionalInt.isPresent());
        System.out.println("optionalInt: " + (optionalInt.isPresent() ? optionalInt.getAsInt() : 0));

        OptionalLong optionalLong = LongStream.rangeClosed(50, 100)
                .min();
        System.out.println("optionalLong min: " + (optionalLong.isPresent() ? optionalLong.getAsLong() : 0));

        OptionalDouble optionalDouble = IntStream.rangeClosed(1, 50)
                .average();
        System.out.println("optionalDouble average: " + (optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0));
    }
}
