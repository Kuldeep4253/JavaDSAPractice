package DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;

public class StairsWays {
    /*
You are climbing a staircase and it takes A steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Return the number of distinct ways modulo 1000000007

Input 1:
 A = 2
Input 2:
 A = 3
Example Output
Output 1: 2
Output 2: 3
Example Explanation
Explanation 1:
 Distinct ways to reach top: [1, 1], [2].
Explanation 2:

 Distinct ways to reach top: [1 1 1], [1 2], [2 1].
     */

    public static void main(String...k){
    }

    public static int climbStairs(int A) {
        int[] dp=new int[A+1];
        Arrays.fill(dp,-1);
        return numberWays(A,dp);
    }


    public static int numberWays(int a, int[] mem){
        if(a==0 || a==1){
            return a ;
        }
        if(mem[a]!=-1){
            return mem[a];
        }
        mem[a]=numberWays(a-1,mem)+numberWays(a-2,mem);
        return mem[a];
    }
}
