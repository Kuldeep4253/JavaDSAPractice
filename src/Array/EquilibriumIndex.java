package Array;

import java.util.Arrays;

public class EquilibriumIndex {

    public static int solve(int[] A) {
        int psum[]=new int[A.length];
        int count=0;
        int right,left;
        psum[0]=A[0];
        for(int i=1;i<A.length;i++){
            psum[i]=psum[i-1]+A[i];
        }
        for(int i=0;i<A.length;i++){
            if(i==0){
                left=0;
                right= psum[A.length-1]-psum[i];
            }
            else if(i==A.length-1){
                right=0;
                left=psum[i-1];

            }
            else{
                left=psum[i-1];
                right=psum[A.length-1]-psum[i];
            }
            if(right==left){
                count++;
                System.out.println("Right sum is :"+right+"and left sum is "+left+" and index is "+i);
            }
        }

        return count;
    }
    public static void main(String...k){
        int A[]={-7, 1, 5, 2, -4, 3, 0};
        System.out.println(solve(A));

    }

}
