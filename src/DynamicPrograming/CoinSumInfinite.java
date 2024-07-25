package DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinSumInfinite {
    /*
    Problem Description
You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of
each coin in the set.
NOTE:
Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).
Problem Constraints
1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000
Input Format
First argument is an integer array A representing the set.
Second argument is an integer B.
Output Format
Return an integer denoting the number of ways.
Example Input
Input 1:
 A = [1, 2, 3]
 B = 4
Input 2:
 A = [10]
 B = 10
Example Output
Output 1:
 4
Output 2:
 1
Example Explanation
Explanation 1:
 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3}
Explanation 2:
 There is only 1 way to make sum 10.
     */

    /***
     *
     * @param A coin array where coin present
     * @param B sum
     * @return total number of way to collect sum when pair can be unordered
     * (x,y)!=(y,x)
     */
    public int coinchange2(int[] A, int B) {
        int[] dp=new int[B+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        // This loop iterate on sum start from 1 to k and collect every possible way to reach sum
        for(int i=1;i<=B;i++){
            //This loop running on coin and check way of sum using this coin
            for(int j=0;j<A.length;j++){
                int coin=A[j];
                if(i-coin>=0){
                    dp[i]=dp[i]+dp[i-coin];
                }
            }
        }
        return dp[B];
    }

    /***
     *
     * @param A coin array where coin present
     * @param B sum
     * @return total number of way to collect sum when pair can be unordered
     * (x,y)==(y,x)
     */
    public int coinchange2ordered(int[] A, int B) {
        int[] dp=new int[B+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        //This loop running on coin and check way of sum using this coin

        for(int i=0;i<A.length;i++){
            int coin=A[i];
            // This loop iterate on sum start from coin to k and collect every possible way to reach sum
            for(int j=coin;j<=B;j++){
                    dp[j]=dp[j]%1000007+dp[j-coin]%1000007;
                }
            }
        return dp[B]%1000007;
    }
    public static void main(String...k){
        int[] a={1,2,3};
        int b=4;
        CoinSumInfinite csi=new CoinSumInfinite();
        System.out.println(csi.coinchange2ordered(a,b));

    }
}
