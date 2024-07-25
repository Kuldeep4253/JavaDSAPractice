package DynamicPrograming;

import java.util.ArrayList;
import java.util.Collections;

class PairNonFractional<T, U> {
    public final T first;
    public final U second;

    public PairNonFractional(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

public class NonFractionKnapsack {
    /*
    This Implementation regarding 0/1 KnapSack
    In 0/1 knap sack Greedy will break so we will go with Dynamic programming
     */

    /*Bottom to Top Approach
    * */

    public static int solveBottomToTopKnapSack(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        return nonFractionKnapSackRec(A,B,A.size()-1,C);
    }

    public static int nonFractionKnapSackRec(ArrayList<Integer> A, ArrayList<Integer> B, int index,int C){
        int pick=0;
        if(index<0 || C==0){
            return 0;
        }
        if(B.get(index)<=C){
            pick=nonFractionKnapSackRec(A,B,index-1,C-B.get(index))+A.get(index);
        }
        int nonpick=nonFractionKnapSackRec(A,B,index-1,C);
               return Math.max(pick,nonpick);
    }
    public static int nonFractionKnapSack(ArrayList<Integer> A, ArrayList<Integer> B, int index,int C){

        int n = A.size();
        int[][] dp = new int[n + 1][C + 1];
        for (int i = 1; i <= n; i++) {
            int weight = B.get(i - 1);
            int value = A.get(i - 1);
            for (int j = 1; j <= C; j++) {
                if (weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][C];

    }

    public static void main(String...k){
        ArrayList<Integer> A=new ArrayList<>();
        A.add(60);
        A.add(100);
        A.add(120);
        ArrayList<Integer> B=new ArrayList<>();
        B.add(10);
        B.add(20);
        B.add(30);
        int C = 50;
        System.out.println(solveBottomToTopKnapSack(A,B,C));
        System.out.println(nonFractionKnapSack(A,B,2,C));

    }

}
