package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestSubArraySumZero {
    public static int lenSubarraySum(List<Integer> A){
        HashMap<Integer,Integer> hs=new HashMap<>();
        int[] psum=new int[A.size()];
        psum[0]=A.get(0);
        int cur=0;
        int len=0;
        for(int i=0;i<A.size();i++){
            cur+=A.get(i);
            psum[i]=cur;
            if(hs.containsKey(cur)){
                len=Math.max(len,i-hs.get(cur));
            }
            if(cur==0){
                len=Math.max(len,i+1);
            }
            else{
                hs.put(cur,i);
            }

        }
        return len;
    }


    public static void main(String...k){
       List<Integer> a=new ArrayList<>();
        a.add(9);
        a.add(-20);
        a.add(-11);
        a.add(-8);
        a.add(-4);
        a.add(2);
        a.add(-12);
        a.add(14);
        a.add(1);
        lenSubarraySum(a);
        int x=10;
        int y=10;
        String temp=x+"#"+y;
        for(int i:a){

        }

    }
}
