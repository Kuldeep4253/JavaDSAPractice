package Array;

public class MinimumSwaps {

    /*
    Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

    Note: It is possible to swap any two elements, not necessarily consecutive.
     */

    public static int solve(int[] A, int B) {
        int window_count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]<B){
                window_count++;
            }
        }

        // Count numbers less than equal to B in first window
        int count = 0;
        for(int i = 0; i < window_count; i++){
            if(A[i] >= B){
                count++;
            }
        }

        // find the window with max numbers with less than equal to B
        int max = count;
        int start_index=1;
        int end_index=window_count;
        while(end_index<A.length)
        {
            if(A[start_index-1] >=B){
                count--;
            }
            else if(A[end_index] >= B ){
                count++;
            }
            if(max < count){
                max = count;
            }
            end_index++;
            start_index++;
        }
        return max;
    }

    public static void main(String...k){
        int [] A={5, 17, 100, 11};
        int B=20;
        System.out.println(solve(A,B));
    }
}
