package Array;

public class SubarrayGivenSumLength {
    /*
    Problem Description
Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise
     */

    /**
     * This is Sliding window problem here Window will increment by 1 so we can use slidinf window concept or we can do via
     * prefix sum concept
     */

    public static int solve(int[] A, int B, int C) {
        int [] psum=new int[A.length];
        int flag=0;
        int start_index=0;
        int end_index=B-1;
        psum[0]=A[0];
        // prefix sum array
        for(int i=1;i<A.length;i++){
            psum[i]=psum[i-1]+A[i];
        }

        int sum=0;
        while(end_index<A.length){
            if(start_index==0){
                sum=psum[end_index];
            }
            else {
                sum = psum[end_index] - psum[start_index - 1];
            }
            end_index++;
            start_index++;
            if(sum==C){
                return 1;
            }
            else{
                flag=0;
            }
        }
        return flag;
    }


    // Through Sliding Window Protocol We can also solve this problem


    public static void main(String...k){
        int [] A={4, 3, 2, 6, 1};
        int B=3;
        int C=11;
        solve(A,B,C);
    }

}
