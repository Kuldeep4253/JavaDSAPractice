package Array;

import java.util.Arrays;

public class SubArrayPrint {
    public static int[][] solve(int[] A) {

        int len=A.length;
        int subarraysize=(len*(len+1))/2;
        int [][] subarray=new int[subarraysize][subarraysize];

        for(int i=0;i<len;i++){
            int [] temp={A[i]};
            subarray[i]=temp;
            for(int j=i+1;j<len;j++){
               int [] temp1={A[i],A[j]};
                subarray[j]=temp1;
            }
        }


        return subarray;
    }

    public static void main(String...q) {
        int[] arr = {1, 2, 3};
        // int[] arr = {1, 2, 3};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
       // System.out.println(Arrays.stream(solve(arr)).toList());

}

