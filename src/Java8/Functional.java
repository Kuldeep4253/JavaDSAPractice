package Java8;


import java.util.ArrayList;

@FunctionalInterface
public interface Functional {
    private static void run() {

    }

    void print(String s);

    default void test1() {
        System.out.println("Hello Test this is a test");
    }

    static void main(String... k) {
        Functional functional = (s) -> System.out.printf("Hello, this is %s method%n", s);
        functional.print("kul");
        Runnable r=()->System.out.println("hellooo");
    }
}


