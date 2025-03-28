package Java8;

import java.util.function.Function;

public class WildCard {
        public static <T, K> void process(Function<? super T, ? extends K> function, T input) {
            K output = function.apply(input);
            System.out.println(output);
        }

        public static void main(String[] args) {
            Function<Object, String> func = Object::toString; // Accepts Object or any supertype of T
            process(func, 123); // Input is an Integer, which is a subtype of Object
        }

    Function<String, String> toUpperCaseFunction = String::toUpperCase;
        String upercase=toUpperCaseFunction.apply("giii");
}
