package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KPlacesApart {
    /*
N people having different priorities are standing in a queue.
The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
Your task is to sort the queue in the increasing order of priorities.
NOTE:
No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).
Example Input
Input 1:
 A = [1, 40, 2, 3]
 B = 2
Input 2:
 A = [2, 1, 17, 10, 21, 95]
 B = 1
Example Output
Output 1:
 [1, 2, 3, 40]
Output 2:
 [1, 2, 10, 17, 21, 95]
 */
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> hp=new PriorityQueue<>();
        ArrayList<Integer> rslt=new ArrayList<>();
        if(B==0){
            return A;
        }
        for(int i=0;i<B;i++){
            hp.add(A.get(i));
        }
        for(int i=B;i<A.size();i++){
            hp.add(A.get(i));
            rslt.add(hp.poll());
        }
        while(!hp.isEmpty()){
            rslt.add(hp.poll());
        }

        return rslt;
    }
    public static void main(String...k){
        ArrayList<Integer> ar=new ArrayList<>(Arrays.asList(25,16,11,31,28,20,3,8));
        int b= 6;
        solve(ar,b);

    }

}
