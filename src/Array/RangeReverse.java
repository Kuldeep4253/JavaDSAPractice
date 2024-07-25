package Array;

import java.util.Arrays;

public class RangeReverse {

    private int[] reverseRange(int a[],int start,int end){
        try {
            while (start <= end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }

        return a ;
    }

    public static void main(String[] k){
        int A[]={-7, 1, 5, 2, -4, 3, 0};
        RangeReverse rr=new RangeReverse();
        rr.reverseRange(A,3,8);
        System.out.println(A[3]);
    }

}
