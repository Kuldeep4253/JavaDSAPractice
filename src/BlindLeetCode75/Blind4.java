package BlindLeetCode75;

import java.util.HashSet;

public class Blind4 {
    /***
     * Can Place Flowers
     * Topics
     * Companies
     * You have a long flowerbed in which some of the plots are planted, and some are not. However,
     * flowers cannot be planted in adjacent plots.
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
     * and an integer n, return true if n new flowers can be planted in the flowerbed without violating the
     * no-adjacent-flowers rule and false otherwise.
     *
     *Example 1:
     *
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: true
     * Example 2:
     *
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: false
     */

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty.
            if (flowerbed[i] == 0) {
                // Check if the left and right plots are empty.
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                // If both plots are empty, we can plant a flower here.
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public static void main(String...k){
        int[] ip={0,1,0};
        Blind4 blind4=new Blind4();
        System.out.println(blind4.canPlaceFlowers(ip,1));
    }


}
