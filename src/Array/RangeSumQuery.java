package Array;

public class RangeSumQuery {

    public static int[] solve(int[] A, int[][] B) {
        int result[]=new int[B.length];
        int prefixsum[]=new int[A.length];
        prefixsum[0]=A[0];
        for(int i=1;i<A.length;i++){
            prefixsum[i]=prefixsum[i-1]+A[i];
        }

        for(int i=0;i<B.length;i++){
            int startindex=B[i][0];
            int endindex=B[i][1];
            if(startindex==0){
                result[i]=prefixsum[endindex];
            }
            else{
                result[i]=prefixsum[endindex]-prefixsum[startindex-1];
            }

        }

        return result;
    }
    public static void main(String...k){
        int A[]={6, 3, 3, 6};
        int B[][]={{1, 2},{1, 3}};
        solve(A,B);
    }
}
