package Heap;

import java.util.PriorityQueue;

public class ConnectingRopes {

    /*
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.
Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [5, 17, 100, 11]
Example Output
Output 1: 33
Output 2: 182
Explanation 1:
 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15
 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.

Explanation 2:
 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133
 So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
     */

    public static int solve(int[] A) {
        int sum = 0;
        int n = A.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(A[i]);
        }
        while(pq.size()>1){
            int val1 = pq.remove();
            int val2 = pq.remove();
            int num = val1+val2;
            sum += num;
            pq.add(num);
        }
        return sum;
    }
    public static void main(String...k){
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(solve(a));

    }



}
