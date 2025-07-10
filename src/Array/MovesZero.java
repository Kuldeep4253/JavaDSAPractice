package Array;

import java.util.Arrays;

public class MovesZero {
    /**
     * Given an integer array nums,
     * move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    public static void moveZeroesLast(int[] nums) {
        int index=0;
        for (int i=0;i<nums.length;i++) {
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
        }
        while(index<nums.length){
            nums[index++]=0;
        }

    }
    public static void moveZeroesFirst(int[] nums) {
        int index=nums.length-1;
        for (int i=nums.length-1;i>=0;i--) {
            if(nums[i]!=0){
                nums[index--]=nums[i];
            }
        }
        while(index>=0){
            nums[index--]=0;
        }

    }
    public static void main(String...k){
        int[] nums={0,1,0,3,12};
        System.out.print("Input is:");
        Arrays.stream(nums).forEach(System.out::println);
        MovesZero.moveZeroesLast(nums);
        System.out.println("\nOutput is:");
        Arrays.stream(nums).forEach(System.out::println);


        System.out.println("\nInput is:");
        Arrays.stream(nums).forEach(System.out::println);
        MovesZero.moveZeroesFirst(nums);
        System.out.println("\nOutput is:");
        Arrays.stream(nums).forEach(System.out::println);

    }
}
