package Interview150LeetCode;

import java.util.*;

public class RemoveElement {
    public static int  removeElement(int[] nums, int val) {

        int count= Arrays.stream(nums)
                .filter(i->i!=val)
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll)
                .toArray()
                .length;

        int[] rslt=new int[nums.length];
        int count1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                rslt[count1++]=nums[i];
            }
        }
        for(int i=0;i<rslt.length;i++){
           nums[i]=rslt[i];
            }
        return count;
    }

    public static void main(String...k){
        int [] nums = {3,2,2,3};
        int val = 3;
        System.out.println(RemoveElement.removeElement(nums,val));
    }
}
