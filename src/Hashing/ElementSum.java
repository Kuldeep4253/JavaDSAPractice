package Hashing;

import java.util.HashMap;

public class ElementSum {
    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            if(hs.containsKey(A[i])){
                hs.put(A[i],hs.get(A[i])+1);
            }
            else
                hs.put(A[i],1);
        }
        int[] rslt=new int[B.length];
        int count=0;
        for(int j=0;j<B.length;j++){
            if(hs.containsKey(B[j])){
                rslt[count++]=hs.get(B[j]);
            }
            else{
                rslt[count++]=0;
            }
        }
        return rslt;
    }

    public static void main(String...k){
        int[] a={6,3,3,6,7,8,7,3,7};
        int[] b={10,9,8};
        System.out.println(solve(a,b));
    }
}
