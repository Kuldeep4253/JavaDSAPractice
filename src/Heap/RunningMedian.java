package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

    /*
    Problem Description
Flipkart is currently dealing with the difficulty of precisely estimating and displaying the expected
delivery time for orders to a specific pin code. The existing method relies on historical delivery
time data for that pin code, using the median value as the expected delivery time. As the order history
expands with new entries, Flipkart aims to enhance this process by dynamically updating the expected
delivery time whenever a new delivery time is added. The objective is to find the expected delivery time
after each new element is incorporated into the list of delivery times. End Goal: With every addition of
new delivery time, requirement is to find the median value.

Why Median ? The median is calculated because it provides a more robust measure of the expected delivery time
The median is less sensitive to outliers or extreme values than the mean. In the context of delivery times,
this is crucial because occasional delays or unusually fast deliveries (outliers) can skew the mean significantly,
 leading to inaccurate estimations.

Given an array of integers, A denoting the delivery times for each order. New arrays of integer B and C are formed,
each time a new delivery data is encountered, append it at the end of B and append the median of array B at the end
of C. Your task is to find and return the array C.

NOTE:
If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

    Example Input
Input 1:

 A = [1, 2, 5, 4, 3]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 1, 2, 2, 3]
Output 2:

 [5, 5, 17, 11]


Example Explanation
Explanation 1:

 Delivery Times      median
 [1]                   1
 [1, 2]                1
 [1, 2, 5]             2
 [1, 2, 5, 4]          2
 [1, 2, 5, 4, 3]       3
Explanation 2:

 Delivery Times     median
 [5]                  5
 [5, 17]              5
 [5, 17, 100]         17
 [5, 17, 100, 11]     11
     */
    public void balance(PriorityQueue<Integer> h1, PriorityQueue<Integer> h2){
        if(h1.size() > h2.size()){
            h2.add(h1.poll());
        }else{
            h1.add(h2.poll());
        }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> h1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> h2 = new PriorityQueue();
        ArrayList<Integer> C = new ArrayList();
        h1.add(A.get(0));
        C.add(A.get(0));
        for(int i = 1; i < A.size(); i++){
            //if element is less than the max element in h1 then add to h1
            if(A.get(i) <= h1.peek()){
                h1.add(A.get(i));
            }else{
                h2.add(A.get(i));
            }
            int diff = Math.abs(h1.size()-h2.size());
            if(diff > 1){
                balance(h1, h2); //this will balance both heaps
            }
            if(h1.size() >= h2.size())
            {
                C.add(h1.peek()); //this will return the max element from h1
            }
            else{
                C.add(h2.peek()); //this will return the min element from h2
            }
        }
        return C;
    }
}
