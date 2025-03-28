package Array;


import java.util.HashMap;

/*
Given an array of integers and a target sum, find two distinct elements in the array that sum up to the target and return their indices.
You cannot use the same element twice
 */
public class TargetTwoNumber {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String...k){
        int[] nums = {2,7,4,5};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
