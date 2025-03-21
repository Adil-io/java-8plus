package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static Optional<Integer> limit(List<Integer> integerList) {
        return integerList.stream()
                // 6, 7, 8, 9, 10
                .limit(2) // limits the elements from the start of stream
                // 6, 7
                .reduce(Integer::sum);
    }

    public static Optional<Integer> skip(List<Integer> integerList) {
        return integerList.stream()
                // 6, 7, 8, 9, 10
                .skip(3) // skips the elements from the start of stream
                // 9, 10
                .reduce(Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        Optional<Integer> optionalLimit = limit(integerList);
        if (optionalLimit.isPresent()) {
            System.out.println("limit: " + optionalLimit.get());
        } else {
            System.out.println("Input List is empty.");
        }

        Optional<Integer> optionalSkip = skip(integerList);
        if (optionalSkip.isPresent()) {
            System.out.println("skip: " + optionalSkip.get());
        } else {
            System.out.println("Input List is empty.");
        }
    }
}
