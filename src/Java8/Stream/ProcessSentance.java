package Java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ProcessSentance {

    /*
    Filter out sentences that contain the word "Java".
    Map each filtered sentences to its length.
    Find the average length of the sentences.
    Convert the average length to an integer by rounding down.
      Return the rounded average length.
     */

    public static int processSentences(List<String> sentences) {

       return (int) sentences.stream()
                .filter(s->s.contains("Java"))
                .mapToInt(String::length)
                .average()
               .orElse(-1);
    }
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is a programming language.", "Python is also a good language.",
                "Java stream processing is powerful.",
                "C++ is not as popular as Java."
        );

        int averageLength = ProcessSentance.processSentences(sentences);
        System.out.println(averageLength);

        sentences = Arrays.asList(
                "Python is a programming language.",
                "JS is used for web development.",
                "Ruby is known for its simplicity.",
                "java is good"
        );

        averageLength = ProcessSentance.processSentences(sentences);
        System.out.println(averageLength);
        List<Number> numbers = Arrays.asList(1, 2.5, 3, 4.5);

        // Create a Function that transforms Numbers into Strings
        Function<? super Number, ? extends String> toStringFunction =
                num -> "Number: " + num.toString();

        // Using the Function with the stream
        numbers.stream()
                .map(toStringFunction)  // Applying the transformation
                .forEach(System.out::println);
    }
}
