package Dsa1;

import java.util.Arrays;
import java.util.Comparator;

public class ElementRemoval {
    /**
     * Given an integer array A of size N. You can remove any element from the array in one operation.
     * The cost of this operation is the sum of all elements in the array present before this operation.
     * Find the minimum cost to remove all elements from the array.
     */

    public static int solveElementRemoval(int[] A) {
        Arrays.sort(A);
        int sum = Arrays.stream(A).sum();
        int cost=0;
        for(int i=0;i<A.length;i++){
            cost+=sum;
            sum-=A[i];
        }
        return cost;
    }
    public static void main(String...k){
        int[] A={8,0,10};
        System.out.println(solveElementRemoval(A));
    }
}
