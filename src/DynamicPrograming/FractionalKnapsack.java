package DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


class Pair<T, U> {
    public final T first;
    public final U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

public class FractionalKnapsack {



    /*
 A = [60, 100, 120]
 B = [10, 20, 30]
 A/B=[6,5,4]

 C = 50
     */
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Pair<Double, Integer>> wpv = new ArrayList<>();
        // Caculating weight per unit
        for (int i = 0; i < A.size(); i++) {
            double temp = (double) A.get(i) / (double) B.get(i);
            wpv.add(new Pair<>(temp, i));
        }
        // Sorting the list based on weight per unit in descending order
        Collections.sort(wpv, (a, b) -> Double.compare(b.first, a.first));


        double ans = 0;
        for (int i = 0; i < A.size(); i++) {
            if (C == 0) {
                break;
            }
            int idx = wpv.get(i).second; // Accessing the second field directly
            int wt = Math.min(C, B.get(idx));//whether we can get the complete value, or our left knapsack capacity C.
            C -= wt;
            ans += (wpv.get(i).first * wt * 1000);//multiply value alongwith its associated wt.
        }
        // Convert ans to floor value and return
        ans /= 10;
        return (int) Math.floor(ans);
    }
    public static void main(String...k){
        ArrayList<Integer> value=new ArrayList<>();
        value.add(16);
        value.add(3);
        value.add(3);
        value.add(6);
        value.add(7);
        value.add(17);
        value.add(13);
        value.add(7);
        ArrayList<Integer> weight=new ArrayList<>();
        weight.add(3);
        weight.add(10);
        weight.add(9);
        weight.add(18);
        weight.add(17);
        weight.add(17);
        weight.add(6);
        weight.add(16);
        weight.add(13);
        int Capacity=11;
        System.out.println(solve(value,weight,Capacity));
    }
}
