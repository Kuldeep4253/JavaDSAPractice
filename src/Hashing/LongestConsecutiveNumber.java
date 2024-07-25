package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveNumber {
    public static int longestConsecutive(final List<Integer> A) {
        HashSet<Integer> hs=new HashSet<>();
        int ans=0;
        int ma=0;
        for(int i:A){
            hs.add(i);
        }
        for(int i:A){
            int copy=i;
            if(!hs.contains(copy-1)){
                int count=1;
                while(hs.contains(copy+1)){
                    copy++;
                    count++;
                }
                ma=Math.max(ma,count);
            }
        }
        return ma;
    }
    public static void main(String...k) {
        List<Integer> a = new ArrayList<>();
        a.add(100);
        a.add(4);
        a.add(200);
        a.add(1);
        a.add(3);
        a.add(2);
        System.out.println(longestConsecutive(a));
    }
}
