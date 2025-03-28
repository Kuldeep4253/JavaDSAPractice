package Array;

import java.util.Collections;

/*
Write a program to print all the Leaders in the array. An element is a Leader if it is greater than all the elements to its right side.
Note: The rightmost element is always a leader.

Examples:

Input: arr[] = {16, 17, 4, 3, 5, 2}
Output: 17 5 2
Explanation:

17 is greater than all the elements to its right: 4, 3, 5 and 2, therefore 17 is a leader.
5 is greater than all the elements to its right: 2, therefore 5 is a leader.
2 has no element to its right, therefore 2 is a leader.

 */
public class ArrayLeaders {
    public static int[]  solve(int[] A) {
        int right_max=A[A.length-1];
        int leader[]=new int[A.length];
        int j=1;
        leader[0] = A[A.length - 1];
        for(int i=A.length-2;i>0;i--){
            if(A[i]> right_max){
                leader[j++]=A[i];
                right_max=A[i];
            }
        }
        int arrsize=0;
        for(int i=0;i<leader.length;i++){
            if(leader[i]!=0){
                arrsize+=1;
            }

        }
        int rsl[]=new int[arrsize];
        for(int i=0;i<arrsize;i++){
            rsl[i]=leader[i];
            System.out.println(leader[i]);
        }
        return leader;
    }
    public static void main(String...k){
        int B[]={93, 57, 83, 41, 100, 10, 79, 27, 94, 22, 4, 96, 48, 18, 89, 37, 21, 5, 46, 81, 15, 30, 47, 23, 34, 65, 55, 9, 36, 20, 54, 17, 7, 56, 78, 84, 87, 97, 16, 69, 28, 11, 44, 49, 8, 25, 98, 75, 53, 62, 19, 24, 80, 68, 50, 91, 1, 86, 77, 14, 72, 66, 42, 63, 73, 45, 31, 61, 85, 64, 35,
                32, 92, 71, 74, 3, 99, 52, 90, 43, 6, 40, 38,
                12, 59, 29, 82, 76, 60, 67, 13, 70, 58, 39, 33, 95, 88, 51, 26};

        System.out.println(solve(B));
    }
}
