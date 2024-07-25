package DynamicPrograming;

import AbstractDesign.WebDeveloper;

import java.util.ArrayList;
import java.util.Arrays;

public class UnboundedKnapsack {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int n=C.size();
        int[][] dp=new int[n][A+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return helper(C,B,n-1,A,dp);
    }

    public int helper(ArrayList<Integer> weight, ArrayList<Integer> value,int index,int K,int[][] dp){
       // Base Case
        if(index<0 || K==0){
            return 0;
        }
       // Check DP table
        if(dp[index][K]!=-1){
            return dp[index][K];
        }
       //Selection Case
        int a=0;
        if(K>=weight.get(index)){
            a=helper(weight,value,index,K- weight.get(index),dp);
        }
       // Rejection Case
        int b=helper(weight,value,index-1,K,dp);
       //Final Answer
        dp[index][K]=Math.max(a,b);
        return dp[index][K];
    }

    public static void main(String...k){
        int a = 10;
        ArrayList<Integer> value=new ArrayList<>();
        value.add(6);
        value.add(7);
        ArrayList<Integer> weight=new ArrayList<>();
        weight.add(5);
        weight.add(5);
        UnboundedKnapsack ubk=new UnboundedKnapsack();
        System.out.println(ubk.solve(a,value,weight));
    }
}
