package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SortArrayGivenOrder {


    /***
     *
     * Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements
     * will be the same as those are in B.
     * For the elements not present in B, append them at last in sorted order.
     *
     * Return the array A after sorting from the above method.
     *
     * NOTE: Elements of B are unique.
     *
     * A = [1, 2, 3, 4, 5, 4]
     * B = [5, 4, 2]
     *
     * o/p: [5, 4, 4, 2, 1, 3]
     * Since 2, 4, 5, 4 of A are present in the array B.  So Maintaining the relative order of B.
     * Thus, [5, 4, 4, 2] and appending the remaining element (1, 3) in sorted order.
     *
     * The Final array is [5, 4, 4, 2, 1, 3]
     *
     *A = [5, 17, 100, 11]
     * B = [1, 100]
     *O/p: [100, 5, 11, 17]
     * Since 100 of A are present in the array B.  So Maintaining the relative order of B.
     * Thus, [100] and appending the remaining element (5, 11, 17) in sorted order.
     *
     * The Final array is [100, 5, 11, 17]
     */

    public static int[]sortArrayOrder(int[] A, int[] B){

        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] ar=new int[A.length];
        for (Integer a:A) {
            if(hm.get(a)!=null){
                hm.put(a,hm.get(a)+1);
            }
            else{
                hm.put(a,1);
            }
        }   // Inserting the element in Hashmap for A array
        int count=0;
        for (Integer a:B) {
            if(hm.containsKey(a)) {
                if(hm.get(a)>1){
                    int size=hm.get(a);
                    for(int j=0;j<size;j++){
                        ar[count++]=a;
                    }
                    hm.remove(a);
                }
                else{
                    ar[count++]=a;
                    hm.remove(a);
                }
            }
        }   // Check If elements of B , present in A then inserting into result array
        ArrayList<Integer> sortedKeys
                = new ArrayList(hm.keySet());

        Collections.sort(sortedKeys);
        for(Integer a:sortedKeys){// reamining element insert from A insert into result
            if(hm.get(a)>1) {
                int size = hm.get(a);
                for (int j = 0; j < size; j++) {
                    ar[count++] = a;
                }
            }
                else{
                    ar[count++] = a;
                }
        }
        return ar;
    }

    public static void main(String...k){
        int[] A = {3,20,17,17};
        int[] B= {5,9,20,11,6,18,7,13};
        System.out.println(SortArrayGivenOrder.sortArrayOrder(A,B));

    }
}

