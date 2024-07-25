package Array;

import java.util.HashMap;
import java.util.HashSet;

public class CountSubarrays {

    /***
     *
     * Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told
     * you to find the number of subarrays of A, that have unique elements.
     *
     * Since the number of subarrays could be large, return value % 109 +7.
     *
     * Input 1:
     *
     *  A = [1, 1, 3]
     *  Output 1: 4
     *  Explanation 1:
     *Subarrays of A that have unique elements only:
     *[1], [1], [1, 3], [3]
     * Input 2:
     *
     *  A = [2, 1, 2]
     * Output 1: 5
     * Explanation 2:
     *  Subarrays of A that have unique elements only:
     *  [2], [1], [2, 1], [1, 2], [2]
     */

    public static int solve(int[] A) {

        int n=A.length;
        int total=(n*(n+1))/2;
        int countDuplicate=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(hs.get(A[i])!=null){
                hs.put(A[i],hs.get(A[i])+1);
                countDuplicate++;
            }
            else{
                hs.put(A[i],1);
            }
        }
        total=total-countDuplicate;

        int adjacentDuplicate=0;
        for(int i=1;i<A.length;i++){
            if(A[i]==A[i-1]){
                adjacentDuplicate++;
            }
            else{
                adjacentDuplicate=0;
            }
        }
        return total;
    }

    public static  int solveScaler(int[] A){
        HashSet<Integer> hs = new HashSet<>();
        long ans = 0;
        int N = A.length, l = 0;
        for(int r = 0; r < N; r++) {
            // check if A[r] is already there in the present window
            while(hs.contains(A[r])) {
                hs.remove(A[l]);
                l++;
            }
            // add the subarrays ending at position r
            ans += r - l + 1;
            hs.add(A[r]);
        }
        return (int)(ans % (long)(1e9 + 7));
    }

    public static void main(String...k){
        int[] A = {1, 1, 3};
        System.out.println(CountSubarrays.solveScaler(A));
    }
}
