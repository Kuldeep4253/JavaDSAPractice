package DynamicPrograming;

import java.util.Arrays;

public class MinimumNumberSquares {

    /*
Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
Example Input
Input 1:
 A = 6
Input 2:
 A = 5
Example Output
Output 1: 3
Output 2: 2
Example Explanation
Explanation 1:
 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3.
Explanation 2:
 We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
     */

    public int countMinSquares(int A) {
        int[] dp=new int[A+1];
        Arrays.fill(dp,-1);
        return MPS(dp , A);
    }
    //memoization
    public int MPS(int[] dp, int N) {
        if(N==0) {
            return 0;
        }
        if(dp[N]==-1) { //solving subproblem 1st time
            int i=1, min=Integer.MAX_VALUE;
            while(i*i <= N ) {
                min=Math.min(min , MPS(dp, N - (i*i) ));
                i++;
            }
            dp[N]=min+1;  //store in dp table
        }
        return dp[N];
    }

}
