package Recursion;

import java.util.Arrays;

public class PalindromePartitioningII {
    int dp[][];
    int min=Integer.MAX_VALUE;
    /*
Given a string A, partition A such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of A.

A = "aab"
op: 1
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     */
    public int minCut(String A) {
        int n = A.length();
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return PalindromePartiotioning(A,0,A.length()-1);
    }

    private int PalindromePartiotioning(String a,int i,int len) {
        if (i >= len || isPalindrome(a, i, len)) {
            return 0;
        }
        if (dp[i][len] != -1) {
            return dp[i][len];
        }
        for(int x=i;x<len;x++){
            int mc1=PalindromePartiotioning(a,i,x);
            int mc2=PalindromePartiotioning(a,x+1,len);
            if(mc1+mc2+1<min){
                min=mc1+mc2+1;
            }
            dp[i][len] = min;
        }

        return dp[i][len];
    }
    boolean isPalindrome(String A, int start, int end) {
        while (start < end) {
            if (A.charAt(start) != A.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String...k){
        String u="dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg";
        PalindromePartitioningII pp=new PalindromePartitioningII();
        System.out.println(pp.minCut(u));
    }


}
