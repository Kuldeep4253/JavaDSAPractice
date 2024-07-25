package Interview150LeetCode;

import java.util.HashMap;
import java.util.Iterator;

public class RemoveDuplicatesSecond {


    /*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each
    unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be
placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first
k elements.
Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with
O(1) extra memory.

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3
respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
     */

    public static int removeDuplicates(int[] nums) {
        /*
        Input: nums = [1,1,1,2,2,3]
        Output: 5, nums = [1,1,2,2,3,_]

        Input: nums = [0,0,1,1,1,1,2,3,3]
        Output: 7, nums = [0,0,1,1,2,3,3,_,_]
         */
        int[] rslt=new int[nums.length];
        int prev=nums[0];
        rslt[0]=nums[0];
        int count=1;
        int j=1;
        for (int i = 1; i < nums.length; i++) {
            if(prev==nums[i] && count<2){
                rslt[j++]=nums[i];
                count++;
                prev=nums[i];
            }
            if(prev!=nums[i]){
                rslt[j++]=nums[i];
                prev=nums[i];
                count=1;
            }
        }
        return j;
    }

    public static void main(String...k){
        int[] a={1,1,1,2,2,3};
        removeDuplicates(a);
    }

}
