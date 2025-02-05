package lambdas;

import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String[] args) {
        // Prior JAVA 8
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };
        System.out.println("comparator " + comparator.compare(3, 2));

        // After JAVA 8
        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);
        System.out.println("comparatorLambda " + comparatorLambda.compare(3, 2));

        Comparator<Integer> comparatorLambda1 = (a, b) -> a.compareTo(b);
        System.out.println("comparatorLambda1 " + comparatorLambda1.compare(3, 2));
    }
}
