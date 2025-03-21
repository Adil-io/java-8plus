package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    private static int findMaxValue(List<Integer> integerList) {
        return integerList.stream()
                // int passed in stream in order one-by-one 6, 7, 8, 9, 10
                // x is assigned the initial value (in this case) -> 0
                // y -> 6, 7, 8, 8, 10
                // x -> holds the max value for each element in the iteration
                .reduce(0, (x, y) -> x > y ? x : y);
    }

    private static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                // .reduce((x, y) -> x > y ? x : y);
                .reduce(Integer::max);
    }

    private static int findMinValue(List<Integer> integerList) {
        return integerList.stream()
                // int passed in stream in order one-by-one 6, 7, 8, 9, 10
                // x is assigned the initial value (in this case) -> 0
                // y -> 6, 7, 8, 8, 10
                // x -> holds the min value for each element in the iteration
                .reduce(0, (x, y) -> x < y ? x : y);
    }

    private static Optional<Integer> findMinValueOptional(List<Integer> integerList) {
        return integerList.stream()
                // .reduce((x, y) -> x < y ? x : y);
                .reduce(Integer::min);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        System.out.println("findMaxValue: " + findMaxValue(integerList));
        List<Integer> emptyList = new ArrayList<>();
        System.out.println("findMaxValue: " + findMaxValue(emptyList));

        Optional<Integer> maxValueOptional = findMaxValueOptional(integerList);
        if (maxValueOptional.isPresent()) {
            System.out.println("findMaxValueOptional: " + maxValueOptional.get());
        } else {
            System.out.println("Input List is empty.");
        }

        maxValueOptional = findMaxValueOptional(emptyList);
        if (maxValueOptional.isPresent()) {
            System.out.println("findMaxValueOptional: " + maxValueOptional.get());
        } else {
            System.out.println("Input List is empty.");
        }

        // Invalid as 0 is used as an initial value
        // Note: Be mindful while using initial value in reduce function
        System.out.println("findMinValue: " + findMinValue(integerList));

        Optional<Integer> minValueOptional = findMinValueOptional(integerList);
        if (minValueOptional.isPresent()) {
            System.out.println("findMaxValueOptional: " + minValueOptional.get());
        } else {
            System.out.println("Input List is empty.");
        }

        minValueOptional = findMinValueOptional(emptyList);
        if (minValueOptional.isPresent()) {
            System.out.println("findMaxValueOptional: " + minValueOptional.get());
        } else {
            System.out.println("Input List is empty.");
        }
    }
}
