package Dsa1;

public class MaximumSumSubarrayEqualK {
    /***
     * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements)
     * so that the sum of contiguous elements is maximum.
     * But the sum must not exceed B.
     *Input 1:
     * A = 5
     * B = 12
     * C = [2, 1, 3, 4, 5]
     * Input 2:
     * A = 3
     * B = 1
     * C = [2, 2, 2]
     * Example Output
     * Output 1:
     * 12
     * Output 2:
     * 0
     */
    public static int MaximumSumSubarrayEqualK(int a, int b,int [] arr){
        int start=0,end=arr.length,maxSum=0,sum=0,left=0;

        while (start < a) {
            sum += arr[start];
            // shrink the window until sum <= B
            while (sum > b && left <= end) {
                sum -= arr[left++];
            }
            maxSum = Math.max(maxSum, sum);
            start++;
        }
        return maxSum;
    }

    public static void main(String...k){
        int[] arr={2, 1, 3, 4, 5};
        System.out.println(MaximumSumSubarrayEqualK(5,12,arr));
    }
}
