package Interview150LeetCode;

public class RemoveDuplicate {

    public static int removeDuplicates(int[] nums) {

        int[] rslt=new int[nums.length];
        rslt[0]=nums[0];
        int count=1,elementpresent=1;
        //[0,0,1,1,1,2,2,3,3,4]
        for(int i=1;i<nums.length;i++){
            if(nums[i]==rslt[count-1]){
            }
            else{
                rslt[count++]=nums[i];
                elementpresent++;
            }
        }
        for(int i=0;i< rslt.length;i++){
            nums[i]=rslt[i];
        }

        return elementpresent;
    }
    public static void main(String...k){
        int[] r={1,1,2};

        System.out.println( RemoveDuplicate.removeDuplicates(r));

    }
}
