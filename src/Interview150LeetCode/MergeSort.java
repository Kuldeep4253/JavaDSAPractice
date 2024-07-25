package Interview150LeetCode;

import java.util.Arrays;

class Solution {
    public  void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] rslt=new int[m+n];
        int i=0;
        int j=0;
        int count=0;
        while(i<=m-1 && j<=n-1){
            if(nums1[i]>nums2[j]){
                rslt[count++]=nums2[j];
                j++;
            }
            else{
                rslt[count++]=nums1[i];
                i++;
            }
        }
        if(i<m-1){
            while(i!=m){
                rslt[count++]=nums1[i];
                i++;
            }
        }
        if(j<n-1){
            while(j!=n){
                rslt[count++]=nums2[j];
                j++;
            }
        }
        System.out.println(Arrays.stream(rslt).iterator());
    }


}

public class MergeSort{
    public static void main(String...k){

        int[] n = new int[]{1, 2, 3, 0, 0, 0};
        int[] n2 = {2,5,6};
        Solution sl=new Solution();
        sl.merge(n,3,n2,3);
    }
}


