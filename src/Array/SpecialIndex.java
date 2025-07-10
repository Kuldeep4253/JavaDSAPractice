package Array;

import java.util.Arrays;

public class SpecialIndex {
    /***
     * An index i in an array is considered special if, after removing the element at index i,
     * the sum of the elements at even indices and the sum of elements at odd indices in the
     * remaining array become equal.
     *
     * For input array: {2, 1, 6, 4}
     * Remove index 1: Array becomes {2, 6, 4}
     * Even index sum: 2 + 4 = 6
     * Odd index sum: 6
     * → Equal → Special index
     * Remove index 3: Array becomes {2, 1, 6}
     * Even: 2 + 6 = 8, Odd: 1 → Not equal
     * ✔️ Output: 1 special index
     */
    public static int getSpecialIndex(int[] arr){
        int[] psumEven=new int[arr.length];
        int[] psumOdd=new int[arr.length];
        int n=arr.length;
        //Creating even odd prefix sum
        for(int i=0;i<arr.length;i++){
            if (i == 0) {
                psumEven[i] = arr[i];  // even index 0
                psumOdd[i] = 0;
            } else {
                if (i % 2 == 0) {
                    psumEven[i] = psumEven[i - 1] + arr[i];
                    psumOdd[i] = psumOdd[i - 1];
                } else {
                    psumOdd[i] = psumOdd[i - 1] + arr[i];
                    psumEven[i] = psumEven[i - 1];
                }
            }
        }

        int sumEven=0;
        int sumOdd=0;
        int ans=0;
        //Traversing Array from 0 to size to remove the index
        for(int i=0;i<arr.length;i++){
            int evenSum = 0;
            int oddSum = 0;

            int totalEven = psumEven[n - 1];
            int totalOdd = psumOdd[n - 1];

            // Left part before i
            int leftEven = i > 0 ? psumEven[i - 1] : 0;
            int leftOdd = i > 0 ? psumOdd[i - 1] : 0;

            // Right part after i shifts index parity
            int rightEven = totalOdd - psumOdd[i];
            int rightOdd = totalEven - psumEven[i];

            evenSum = leftEven + rightEven;
            oddSum = leftOdd + rightOdd;

            if (evenSum == oddSum) {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String...k){
        int [] arr={2, 1, 6, 4};
        System.out.println(SpecialIndex.getSpecialIndex(arr));


    }
}
