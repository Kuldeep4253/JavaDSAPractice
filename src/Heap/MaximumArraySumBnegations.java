package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumArraySumBnegations {

    /*
    Problem Description
Given an array of integers A and an integer B. You must modify the array exactly B number of times.
In a single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications,
sum of the array must be maximum.
NOTE: You can perform the modification on the same element multiple times.

nput 1:

 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:

 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10


Example Output
Output 1:

 196
Output 2:

 362


Example Explanation
Explanation 1:


Operation 1: Make -29 to 29,
Operation 2: Make -9 to 9,
Operation 3: Make 9 to -9,
Operation 4: Make -68 to 68.
Thus, the final array after 4 modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
     */
    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<A.size();i++){
                pq.add(A.get(i));

        }
        for(int i=0;i<B;i++){
            int val=pq.remove();
            pq.add(-1*val);
        }
        int ans=0;
        while(pq.size()>0){
            ans+=pq.remove();
        }
        return ans;
    }
    public static void main(String...k){
       ArrayList<Integer> a=new ArrayList<Integer>(Arrays.asList(5, 13, -2, 11, 27, 31, 0, 19));
        solve(a,4);
    }
}
