package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestPalindromeString {

    public static int expandString(String str,int left,int right){
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        // return length of palindrome
        return right - left - 1;
    }
    public static void main(String...k){
        String s="babad";
        int maxLen=0 ,start=0  ,end=0;
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandString(s, i, i);       // Odd length palindrome
            int len2 = expandString(s, i, i + 1);   // Even length palindrome
            int len = Math.max(len1, len2);
            // Check and collect odd palindrome
            if (len1 >= maxLen) {
                if (len1 > maxLen) result.clear();
                maxLen = len1;
                start = i - (len1 - 1) / 2;
                result.add(s.substring(start, start + len1));
            }

            // Check and collect even palindrome
            if (len2 >= maxLen) {
                if (len2 > maxLen) result.clear();
                maxLen = len2;
                start = i - (len2 - 2) / 2;
                result.add(s.substring(start, start + len2));
            }
        }

        System.out.println(new ArrayList<>(result));


    }
}
