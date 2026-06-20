package String;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmailGenerateFromString {
    /**
     *S = "john Doe; Peter Benjamin Parker; Mary Jane Watson-Parker"
     * C = "example.com"
     * generate email id for each in format "firstname.lastname@example.com"
     * For duplicate email append number at end.
     */

    public static void main(String...k){
        String s="john Doe; Peter Benjamin; Parker Mary; Jane Watson-Parker";
        String C = "example.com";
        Map<String, Integer> emailCount = new HashMap<>();
        String result1=Arrays.stream(s.split(";")).map(String::trim)
                .map(String::toLowerCase)
                .map(fullname->{
                    String[] parts=fullname.split("//s+");
                    String firstName = parts[0];
                    String lastName = parts[parts.length - 1].replace("-", "");
                    String base = firstName + "." + lastName;
                    int count = emailCount.getOrDefault(base, 0);
                    emailCount.put(base, count + 1);
                    return base + (count > 0 ? (count + 1) : "") + "@" + C;
                }).collect(Collectors.joining("; "));

        // Step 1: extract base names (firstname.lastname)
        List<String> baseEmails = Arrays.stream(s.split(";"))
                .map(String::trim)
                .map(String::toLowerCase)
                .map(fullName -> {
                    String[] parts = fullName.split("\\s+");
                    String firstName = parts[0];
                    String lastName = parts[parts.length - 1].replace("-", "");
                    return firstName + "." + lastName;
                })
                .collect(Collectors.toList());

        // Step 2: create a counter map using groupingBy
        Map<String, Long> counts = baseEmails.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));


        // Step 3: rebuild emails with numbering for duplicates
        Map<String, Integer> used = new HashMap<>();
        String result = baseEmails.stream()
                .map(base -> {
                    int occurrence = used.merge(base, 1, Integer::sum);
                    return base + (occurrence > 1 ? occurrence : "") + "@" + C;
                })
                .collect(Collectors.joining("; "));

        System.out.println(result);
        

    }
}
