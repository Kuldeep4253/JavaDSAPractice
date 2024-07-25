package Array;

public class CountTriplet {
    public static int solve(int[] A, int[] B) {

        int left;
        int right;
        int count=0;
        int lefttreeheight=Integer.MAX_VALUE;
        int righttreeheight=Integer.MAX_VALUE;
        int finaltreeheight=Integer.MAX_VALUE;
        for(int i=1;i<A.length-1;i++){
            left=0;
            right=0;
            // left side index x which are less than A[i]
            for(int j=0;j<=i-1;j++){
                if(A[j]<A[i]){
                    left++;
                    lefttreeheight=Math.min(lefttreeheight,B[j]);
                }
            }
            // Right side index x which are greater than A[i]
            for(int j=i+1;j<A.length;j++){
                if(A[j]>A[i]){
                    right++;
                    righttreeheight=Math.min(righttreeheight,B[j]);
                }
            }

            count+=left*right;
            finaltreeheight=Math.min(finaltreeheight,righttreeheight+lefttreeheight+B[i]);
        }
        return finaltreeheight;
    }


    public static void main(String...k){
        int A[] = {1,3,5};
        int B[]={1,2,3};
        solve(A,B);

    }
}
