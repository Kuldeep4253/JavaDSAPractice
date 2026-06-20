package Array;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaxMinSubarray {
    public static int subArray(int[] A){
        // Find min and max values
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            min1 = Math.min(min1, A[i]);
            max2 = Math.max(max2, A[i]);
        }

        int last_min_index = -1, last_max_index = -1;
        int min_sublen = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == min1) {
                last_min_index = i;
                if (last_max_index != -1) {
                    min_sublen = Math.min(min_sublen, Math.abs(last_min_index - last_max_index) + 1);
                }
            }
            if (A[i] == max2) {
                last_max_index = i;
                if (last_min_index != -1) {
                    min_sublen = Math.min(min_sublen, Math.abs(last_min_index - last_max_index) + 1);
                }
            }
        }
        return min_sublen;
    }

    public static void main(String...k){
        int [] arr = {377,448,173,307,108};
        System.out.println(subArray(arr));

    }
}
