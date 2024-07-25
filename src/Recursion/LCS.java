package Recursion;

import java.util.Arrays;

public class LCS {
    public int dp[][];
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return lcs(A, n-1, B,m-1);
    }

    public int lcs(String s1,int i,String s2,int j){
        // Base Case
        if(i<0 || j<0){
            return 0;
        }
        // When Already Result is stored in dp for recursive call
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        // When recursive call come first time
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+lcs(s1,i-1,s2,j-1);
        }
        else{
            int a1=lcs(s1,i-1,s2,j);
            int a2=lcs(s1,i,s2,j-1);
            ans=Math.max(a1,a2);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public static void main(String...k){
        String A = "abbcdgf";
        String B = "bbadcgf";
        LCS lc1=new LCS();
        System.out.println(lc1.solve(A,B));
    }
}
