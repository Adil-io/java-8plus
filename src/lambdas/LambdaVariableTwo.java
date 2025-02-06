package lambdas;

import java.util.function.Consumer;

/**
 * <p>
 * Lambdas have some restrictions on using local variables
 *    <ol>
 *        <li>
 *            Not allowed to use the same the local variable name as lambda parameters or inside the lambda body.
 *        </li>
 *        <li>
 *            Not allowed re-assign a value to a local variable.
 *        </li>
 *    </ol>
 * </p>
 *
 * <p>
 * Note: No restrictions on instance variables
 * </p>
 */
public class LambdaVariableTwo {

    static int instanceVariable = 4;

    public static void main(String[] args) {
        int localVariable = 4;
        Consumer<Integer> c1 = (i) -> {
            // Invalid
            // localVariable++
            System.out.println(localVariable + i);
        };
        // Invalid
        // localVariable = 6;
        c1.accept(4);

        Consumer<Integer> c2 = (i) -> {
            instanceVariable++;
            System.out.println(instanceVariable + i);
        };
        c2.accept(4);
    }
}
