package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class CountPairSum {

    private int findCountPair(int [] arr,int k){
        HashMap<Integer,Integer> hs= new HashMap<>();
        int count=0;
        for (int value : arr) {
            int j = k - value;
            if (hs.containsKey(j)) {
                count = count + hs.get(j);
                hs.put(value, 0);
            }
            if (hs.containsKey(value)) {
                hs.put(value, hs.get(value) + 1);
            } else {
                hs.put(value, 1);
            }

        }
        return count;
    }

    public static void main(String...k){
        int[] arr ={1,2,3,4,5,5,6,7,8,9};
        CountPairSum cp=new CountPairSum();
        System.out.println(cp.findCountPair(arr,10));

    }
}
