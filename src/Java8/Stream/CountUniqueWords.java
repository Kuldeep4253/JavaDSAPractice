package Java8.Stream;

import java.util.Arrays;
import java.util.List;

public class CountUniqueWords {
    /*
    Filter out sentences that don't contain the word "Java".
Map each filtered sentences to a list of unique words (remove duplicates).
Flatten the list of unique words into a single stream of words. Hint: Use flatMap(Arrays::stream) Method
Count the total number of remaining words.
Return the count of remaining words.
     */

    public static long countWords(List<String> sentences) {
        return sentences.stream().
                filter(sentence -> !sentence.contains("Java"))
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Python is a programming language.",
                "JavaScript is used for web development.",
                "Ruby is known for its simplicity."
        );

        long wordCount = CountUniqueWords.countWords(sentences);
        System.out.println(wordCount);
    }
}
