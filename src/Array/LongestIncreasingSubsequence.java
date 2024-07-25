package Array;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    /*
    Problem Description
Find the longest increasing subsequence of a given array of integers, A.
In other words, find a subsequence of array in which the subsequence's elements are in strictly
increasing order, and in which the subsequence is as long as possible.
In this case, return the length of the longest increasing subsequence.
     */
    int dp[];
    public int lis(final List<Integer> A) {
        dp=new int[A.size()];
        Arrays.fill(dp,1);

        return LIS(A);
    }

    private int LIS(List<Integer> A) {
        for(int i=1;i<A.size();i++){
            for(int j=0;j<i;j++){
                if(A.get(i)>A.get(j) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}
