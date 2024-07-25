package Hashing;

import java.util.HashSet;

public class FindPairSum {

    private boolean findPair(int [] arr,int k){
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int j=k-arr[i];
            if(!hs.contains(j)){
                hs.add(arr[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String...k){
        int arr[]={1,2,3,4,5,6,7,8};
        FindPairSum fd=new FindPairSum();
        System.out.println(fd.findPair(arr,2));

    }
}
