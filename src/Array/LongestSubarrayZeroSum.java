package Array;

import java.util.HashMap;

public class LongestSubarrayZeroSum {
// [1, -2, 1, 2]

    //[1,2,3,4,5,6]
    public static int findLength(int[] A) {
        int[] psum=new int[A.length];
        psum[0]=A[0];
        // Create Prefix sum
        for(int i=1;i< A.length;i++){
            psum[i]=psum[i-1]+A[i];
        }

        for(int i=A.length-1;i>=0;i--){
            if(psum[i]==0){
                return i+1;
            }
        }

        return 0;
    }    // Using Array and prefix sum

    public static int findLengthusingHashMap(int[] A) {

        HashMap<Long, Integer> pref = new HashMap<Long, Integer>();
        Long curr = 0L;
        int ans = 0;
        pref.put(0L, 0);
        for (int i = 1; i <= A.length; i++) {
            curr += A[i - 1];
            if (pref.containsKey(curr)) {
                ans = Math.max(ans, i - pref.get(curr));
            } else {
                pref.put(curr, i);
            }
        }
        return ans;
    }

    public static void main(String...k){
        int[] r={9,-20,-11,-8,-4,2,-12,14,1};
        System.out.println(LongestSubarrayZeroSum.findLength(r));
        //System.out.println(LongestSubarrayZeroSum.findLengthusingHashMap(r));


    }
}
