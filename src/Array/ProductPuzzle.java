package Array;

public class ProductPuzzle {
    public static int[] solve(int[] A) {
        int multi=1;

        for(int i=0;i<A.length;i++){
            multi=multi*A[i];
        }

        int result[]=new int[A.length];

        for(int i=0;i<A.length;i++){
            result[i]=multi/A[i];
        }
        return result;
    }
    public static void main(String...k){
        int A[]={1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }
}

