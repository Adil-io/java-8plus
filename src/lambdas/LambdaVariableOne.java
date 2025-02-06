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
public class LambdaVariableOne {

    public static void main(String[] args) {
        int i = 0;
        // This is Invalid
        // Consumer<Integer> c1 = (i) -> System.out.println(i);

        // This is valid
        Consumer<Integer> c1 = (j) -> System.out.println(j);
    }
}
