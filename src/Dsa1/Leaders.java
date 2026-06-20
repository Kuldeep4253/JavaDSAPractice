package Dsa1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leaders {

    /***
     * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
     * An element is a leader if it is strictly greater than all the elements to its right side.
     * @param A
     * @return
     * A = [16, 17, 4, 3, 5, 2]
     * [17, 2, 5]
     * Element 17 is strictly greater than all the elements on the right side to it.
     *  Element 2 is strictly greater than all the elements on the right side to it.
     *  Element 5 is strictly greater than all the elements on the right side to it.
     * So we will return these three elements i.e [17, 2, 5],
     * we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
     */

    public static int[] solve(int[] A) {
        List<Integer> li=new ArrayList<>();
        int index=0;
        for(int i=A.length-1;i>=0;i--){
            if(i==A.length-1){
                li.add(A[i]);
            }
            else{
                if(li.get(index)<A[i]){
                    li.add(A[i]);
                    index++;
                }
            }
        }
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }

        return result;
    }
    public static void main(String...k){
        int[] A={16, 17, 4, 3, 5, 2};
        Arrays.stream(solve(A)).forEach(System.out::println);

    }
}
