package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsVsStream {

    public static void main(String[] args) {
        System.out.println("===> Names Collection <===");
        List<String> names = new ArrayList<>();
        names.add("adam");
        names.add("jim");
        names.add("jenny");
        System.out.println("List before remove");
        // External traversal of elements for Collections
        for (String name : names) {
            System.out.println(name);
        }
        names.remove(2);
        System.out.println("List after remove");
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("===> Names Stream <===");
        Stream<String> namesStream = names.stream();
        // Internal traversal of elements for Stream
        namesStream.forEach(System.out::println);
        // Invalid since in streams we can traverse only once
        namesStream.forEach(System.out::println);
    }
}
