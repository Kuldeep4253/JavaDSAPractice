package Recursion;

import java.util.Arrays;

public class RegularExpressionMatch {
    int dp[][];
    /*
    Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).

Input 1:

 A = "aaa"
 B = "a*"

 ans:1
     */
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return regexMatch(A,n,B,m);
    }

    public int regexMatch(String A,int i,String B,int j){
        if(A.charAt(i)!=B.charAt(j)){
            return 0;
        }
        if(A.charAt(i)==B.charAt(j) || B.charAt(j)=='?'){
            int res=regexMatch(A,i-1,B,j-1);
            dp[i][j]=res;
            return res;
        }
        if(B.charAt(j) == '*'){
            int a = regexMatch(A,i-1,B, j);
            int b = regexMatch(A,i,B, j-1);
            if(a== 1 || b== 1){
                dp[i][j] = 1;
                return  1;
            }
        }
        dp[i][j]=0;
        return dp[i][j];
    }
}
