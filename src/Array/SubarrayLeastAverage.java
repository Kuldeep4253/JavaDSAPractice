package Array;

public class SubarrayLeastAverage {

    public static int solve(int[] A, int B) {

        //find the sum of first window size
        int sum = 0;
        int ans = 0;
        for(int i=0; i<B; i++){
            sum+=A[i];
        }
        ans = 0;
        int minSum = sum;
        for(int i=B; i<A.length; i++){
            sum = sum - A[i-B] + A[i];
            if(sum < minSum){
                minSum = sum;
                ans = i-B+1;
            }
        }

        return ans;
    }

    public static void main(String...k){
        int [] A={20,3,13,5,10,14,8,5,11,9,1,11};
        int B=9;
        System.out.println(solve(A,B));
    }
}
