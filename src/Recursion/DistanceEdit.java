package Recursion;

import java.util.Arrays;

public class DistanceEdit {
    int dp[][];
    /*
Given two strings A and B, find the minimum number of steps required to convert A to B.
(each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character

Input 2:

 A = "Anshuman"
 B = "Antihuman

 ans:2 replace t with s and delete i
    */
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return distance(A, n-1, B,m-1);
    }

    public int distance(String s1,int i,String s2,int j){
        // Base case when s1 is empty and s2 is not so we need to insertion as s2 length
        if(i<0){
            return j+1;
        }
        // Base case when s1 is not empty and s2 is empty so we need to deletion as s1 length
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        // If character match with other string
        if(s1.charAt(i)==s2.charAt(j)){
            ans=distance(s1,i-1,s2,j-1);
        }
        // If Character not matched so Need to all 3 operation and check it which takes min distance
        else{
            int replace=distance(s1,i-1,s2,j-1);
            int insert=distance(s1,i,s2,j-1);
            int delete=distance(s1,i-1,s2,j);
            ans=Math.min(Math.min(replace,insert),delete)+1;
        }
        dp[i][j]=ans;
        return dp[i][j];
    }
    public static void main(String...k){
        String A = "Anshuman";
        String B = "Antihuman";
        DistanceEdit de=new DistanceEdit();
        System.out.println(de.minDistance(A,B));
    }
}
