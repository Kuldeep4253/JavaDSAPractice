package Interview150LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class MajorityElement {
    public  static int  majorityElement(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < size; i++)
        {
            if(hm.containsKey(nums[i]))
            {
                int count = hm.get(nums[i]) + 1;
                if (count > size/2)
                {
                    return nums[i];
                }

                else
                {
                    hm.put(nums[i], count);
                }

            }
            else
            {
                hm.put(nums[i], 1);
            }
        }

// if the control reaches here, then it means
// the majority element is not found.
        return -1;
    }

    public static void main(String...k){
        int [] nums = {3,2,3};
        System.out.println(MajorityElement.majorityElement(nums));
    }
}
