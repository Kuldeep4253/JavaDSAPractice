package Interview150LeetCode;

public class ReverseKthTime {

    public static void rotate(int[] nums, int k) {
        if(k>=nums.length){
            k=k%nums.length;
        }
        if(k==0){
            nums=nums;
        }
        else{
            reverseRange(nums, 0, nums.length - 1);
            reverseRange(nums, 0, k - 1);
            reverseRange(nums, k, nums.length - 1);
        }


    }

    public static int [] reverseRange(int[] nums, int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return nums;
    }

    public static void main(String...k){
        int[] nums = {1,2};
        ReverseKthTime.rotate(nums,3);


    }
}
