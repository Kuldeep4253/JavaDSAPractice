package Dsa1;

public class CountingSubarraysSumLessK {
    /***
     * Problem Description
     *
     * Given an array A of N non-negative numbers and a non-negative number B,
     * you need to find the number of subarrays in A with a sum less than B.
     * We may assume that there is no overflow.

     * Example Input
     *
     * Input 1:
     *  A = [2, 5, 6]
     *  B = 10
     * Input 2:
     *  A = [1, 11, 2, 3, 15]
     *  B = 10
     *
     * Example Output
     * Output 1:
     *  4
     * Output 2:
     *  4
     * Example Explanation
     * Explanation 1:
     *  The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
     * Explanation 2:
     *  The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
     */
    public static int solve(int[] A, int B) {
        int n=A.length;
        int[] psum=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                psum[i]=A[i];
            }else{
                psum[i]=psum[i-1]+A[i];
            }
        }
        int count=0;
        for (int i=0;i<n;i++){
            long sum;
            for (int j=i;j<n;j++){
                if(i==0){
                     sum=psum[j];
                }
                else {
                     sum = psum[j] - psum[i-1];
                }
                if(sum<B){
                    count++;
                }
                else{
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String...k){
        int[] A={1, 11, 2, 3, 15};
        //{1}, {2}, {3} and {2, 3}
        System.out.println(solve(A,10));
    }
}
