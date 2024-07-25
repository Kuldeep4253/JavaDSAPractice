/*Problem Description
Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.


Problem Constraints
1 <= len(A) <= 103
1 <= A[i] <= 103
1 <= B <= 107


Input Format
The first argument given is the integer array A.
The second argument given is an integer B.


Output Format
Return the count of good subarrays in A.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 4
Input 2:

A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
B = 65


Example Output
Output 1:
6
Output 2:

36
*/



package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GoodSubArrays {
    public static int solve(int[] A, int B) {
        int N=A.length;
        for (int i=1; i<N; i++) A[i]=A[i-1]+A[i]; // Create pSum.

        int sum,count=0;
        for (int i=0; i<N; i++){
            for (int j=i; j<N; j++){
                int len=j-i+1;
                if (i!=0) sum=A[j]-A[i-1];
                else sum=A[j];

                if((len%2==0 & sum<B) | (len%2!=0 & sum>B)) count++;
                // Condition 1. if len is 'even' sum should be less than B.
                // Condition 2. if len is 'odd' sum should be greter than B.
            }
        }
        return count;
    }

    public static void main(String...k){

        int [] arr1={1, 2, 3, 4, 5};

        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

       // System.out.println(solve(arr,6));
    }
}

