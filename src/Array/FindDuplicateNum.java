package Array;

public class FindDuplicateNum {

    public static int singleNumber(final int[] A) {
        //Given an array of integers A, every element appears twice except for one. Find that integer
        // that occurs once.
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }

    public static void main(String... k) {
        int A[]={1, 2, 2, 3, 1,5,5,6};
        System.out.println(singleNumber(A));
    }
}
