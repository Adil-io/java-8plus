package lambdas;

public class RunnableLambda {

    public static void main(String[] args) {

        // Prior JAVA 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Legacy Runnable 1");
            }
        };
        new Thread(runnable).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Legacy Runnable 2");
            }
        }).start();

        // After JAVA 8
        Runnable runnableLambda = () -> System.out.println("Lambda Runnable 1");
        new Thread(runnableLambda).start();
        new Thread(() -> System.out.println("Lambda Runnable 2")).start();
    }

}
