package Array;

/*You are given an array A of length N and Q queries given by the 2D array B of size Q×2.

Each query consists of two integers B[i][0] and B[i][1].

For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].*/

public class EvenNumInRange {
    public static int[] solve(int[] A, int[][] B) {
        int a[]=new int[B.length];

        for (int i = 0; i < B.length; i++) {
            int count=0;
            for (int j = B[i][0]; j <= B[i][1]; j++) {
                if(j%2==0){
                    count+=A[j];
                }
            }
            a[i]=count;
            System.out.println(count);
        }
        return a;
    }

    public static void main(String... k) {
        int A[]={16,3,3,6,7,8,17,13,7};
        int B[][]={{2,6},{4,7},{6,7}};
        System.out.println(solve(A,B));


    }

}
