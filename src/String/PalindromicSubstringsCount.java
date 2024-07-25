package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PalindromicSubstringsCount {
    boolean dp[][];
    /*
Given a string A consisting of lowercase English alphabets. Your task is to find how many substrings of A are palindrome.
The substrings with different start indexes or end indexes are counted as different substrings even if they consist of same characters.
Return the count of palindromic substrings.
Note: A string is palindrome if it reads the same from backward and forward.
Input 2:
    A = "ababa"
Output 2:
    9
Explanation 9:
    9 palindromic substrings are:
    "a", "a", "a", "b", "b" , "aba" ,"bab", "aba" and "ababa".
     */
    public int solve(String A) {
        int count=0;
        int lensub=1;
        dp=new boolean[A.length()][A.length()];
        for(int i=0;i<A.length();i++){
            dp[i][i]=true;
            count++;
        }
        for(int i=0;i<A.length()-1;i++){
            if(A.charAt(i)==A.charAt(i+1)){
                count++;
                lensub=2;
                dp[i][i+1]=true;
            }
        }
        int len=3;
        while(len<=A.length()){

            int i=0;
            int j=len-1;
            while(j<A.length()){
                if(A.charAt(i)==A.charAt(j) && dp[i+1][j-1]==true){
                    count++;
                    dp[i][j]=true;
                    len=j-i+1;
                    lensub=len;
                }
                i++;
                j++;
            }
            len++;
        }

        return lensub;
    }
    public static void main(String...k){
        String y="bebdeeedaddecebbbbbabebedc";
        PalindromicSubstringsCount psc=new PalindromicSubstringsCount();
        System.out.println(psc.solve(y));
    }
}
