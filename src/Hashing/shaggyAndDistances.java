package Hashing;

import java.util.HashMap;

public class shaggyAndDistances {
    /***
     *
     *
     * Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if
     * elements at those indices in the array are equal.
     *
     * Shaggy wants you to find a special pair such that the distance between that pair is minimum.
     * Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
     *
     * A = [7, 1, 3, 4, 1, 7]
     * o/p: 3
     *
     * Here we have 2 options:
     * 1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
     * 2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
     * Therefore the minimum possible distance is 3.
     */


    public static int distance(int[] A){
        if (A.length == 1) {
            return -1;
        }
        // stores <Value, Index> pair
        HashMap< Integer, Integer > map = new HashMap < Integer, Integer > ();
        int result = A.length;
        for (int i = 0; i < A.length; i++) {
            // checks if A[i] has occurred previously
            if (map.containsKey(A[i])) {
                result = Math.min(result, i - map.get(A[i]));
            }
            map.put(A[i], i);
        }
        return (result == A.length) ? -1 : result;
    }

    public static void main(String...k){
        int[] A={7, 1, 3, 4, 1, 7};
        System.out.println(shaggyAndDistances.distance(A));


    }
}
