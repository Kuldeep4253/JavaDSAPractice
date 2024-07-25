package Heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinimumLargestElement {
    /***
     * This class is used for to store state element with index and compare value
     */
    class Pair{
        int val;
        int ind;
        public Pair(int a, int b){
            this.val = a;
            this.ind = b;
        }
    }
    /*
    Problem Description
Given an array A of N numbers, you have to perform B operations. In each operation,
you have to pick any one of the N elements and add the original value(value stored at the index before we did any
operations) to its current value. You can choose any of the N elements in each operation.

Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.
Input 1:

 A = [1, 2, 3, 4]
 B = 3
Input 2:

 A = [5, 1, 4, 2]
 B = 5


Example Output
Output 1:

 4
Output 2:

 5


Example Explanation
Explanation 1:

 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
Explanation 2:

 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.

     */

    public int solve(int[] A, int B) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a,Pair b){
                return a.val - b.val;
            }
        });
        int n = A.length;
        int[] state = A.clone();
        // This loop will store the next State of array like (val,index)
        /*

 A = [1, 2, 3, 4]

 [2,0] for 0 index # [4,1] for 1 index  # [6,2] for 2 index  # [8,3] for 3 index
 and will compare two pair and return value
         */
        for (int i=0;i<A.length;i++){
            Pair pair=new Pair(2*A[i],i);
            pq.add(pair);
        }

        // This while loop execute B time and update the state of array B time and select minimum pair from queue each time
        while(B>0){
            int value = pq.peek().val;
            int index = pq.peek().ind;
            pq.remove();

            /*
            Lets see line number 77 , For [4,1] for 1 index
            state[1]=state[1]+A[1]  Update pair  #[6,1] and then push new pair in queue
             */
            state[index] += A[index];//Adding original value to state value
            Pair p = new Pair(state[index]+A[index], index);
            pq.add(p);
            B--;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(state[i], max);
        }
        return max;
    }
}
