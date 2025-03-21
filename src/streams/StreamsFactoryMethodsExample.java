package streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Streams API - Factory Methods - of(), iterate() and generate()
 * 1. of() -> Creates a stream of certain values passed to this method.
 * E.g. Stream<String> stringStream = Stream.of("adam", "dan", "Julie");
 * 2. iterate(), generate() -> Used to create infinite Streams.
 * iterate() -> E.g. Stream.iterate(1, x -> x * 2)
 * generate() -> E.g. Stream.generate(<Supplier>)
 */
public class StreamsFactoryMethodsExample {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("adam", "dan", "julie");
        stringStream.forEach(System.out::println);

        /*
        Short circuit methods allows the stream to not iterate over each and every element in the stream
        Streams API short-circuit methods are ->
            limit(), findFirst(), findAny(), allMatch(), anyMatch(), noneMatch()
         */

        Stream.iterate(1, x -> x * 2)
                .limit(10) // introduced a short-circuit method to avoid infinite loop
                .forEach(System.out::println);

        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(5) // introduced a short-circuit method to avoid infinite loop
                .forEach(System.out::println);
    }
}
