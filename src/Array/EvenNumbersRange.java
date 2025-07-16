package Array;

import java.util.Arrays;

public class EvenNumbersRange {
    public static int[] solve(int[] A, int[][] B) {
        int[] peven=new int[A.length];
        int[] podd=new int[A.length];
        for(int i=0;i<A.length;i++){
            if(i==0){
                if(A[i]%2==0){
                    peven[i]=1;
                    podd[i]=0;
                }
                else{
                    podd[i]=1;
                    peven[i]=0;
                }
            }
            else{
                if(A[i]%2==0){
                    peven[i]=peven[i-1]+1;
                    podd[i]=podd[i-1];
                }
                else{
                    podd[i]=podd[i-1]+1;
                    peven[i]=peven[i-1];
                }
            }
        }
        int[] result = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int l = B[i][0];
            int r = B[i][1];
            int even = peven[r] - (l > 0 ? peven[l - 1] : 0);
            result[i]=even;
        }
        return result;
    }
    public static void main(String...k){
        int[] a={6,3,3,6,7,8,7,3,7};
        int[][] b={{2,6},{4,7},{6,7}};
        Arrays.stream(EvenNumbersRange.solve(a,b))
                .forEach(System.out::println);

    }
}
