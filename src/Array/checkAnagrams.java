package Array;

import java.util.Arrays;

public class checkAnagrams {
    /*
You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0
if not.
Note : Two strings A and B are called anagrams to each other if A can be
formed after rearranging the letters of B.
Example Input
Input 1:
A = "cat"
B = "bat"
Input 2:
A = "secure"
B = "rescue"
Example Output
Output 1:
0
Output 2:
1
Example Explanation
For Input 1:
The words cannot be rearranged to form the same word. So, they are not anagrams.
For Input 2:
They are an anagram.
     */

    public int solve(String A, String B) {
        // Convert strings to character arrays and sort them
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
// Check if the sorted arrays are equal
        return Arrays.equals(arrA, arrB) ? 1 : 0;
    }
}
