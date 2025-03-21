package numeric_streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample {

    // Primitive type to Wrapper type
    public static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 10) // int Stream of Primitive type int -> 10 elements
                // Input -> Primitive int
                .boxed()
                // Output -> Stream<Integer>
                .collect(Collectors.toList());
    }

    // Wrapper type to Primitive type
    public static int unboxing(List<Integer> integerList) {
        return integerList.stream()
                // Input -> Wrapper Integer
                .mapToInt(Integer::intValue)
                // Output -> IntStream of int Primitive type
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Boxing: " + boxing());

        List<Integer> integerList = boxing();
        System.out.println("Unboxing: " + unboxing(integerList));
    }
}
