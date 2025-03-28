package BlindLeetCode75;

import java.util.ArrayList;
import java.util.List;

public class Blind2 {

    /**
     * Kids With the Greatest Number of Candies
     * We are given an integer array candies, where each candies[i] represents the number of candies the i
     * th
     *   kid has, and an integer extraCandies, denoting the number of extra candies that you have.
     *
     * Our task is to return a boolean array result of length n, where result[i] is true if, after giving the i
     * th
     *   kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
     *
     * Input: candies = [2,3,5,1,3], extraCandies = 3
     * Output: [true,true,true,false,true]
     * Explanation: If you give all extraCandies to:
     * - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
     * - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
     * - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
     * - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
     * - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
     * Example 2:
     *
     * Input: candies = [4,2,1,1,2], extraCandies = 1
     * Output: [true,false,false,false,false]
     * Explanation: There is only 1 extra candy.
     * Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
     * Example 3:
     *
     * Input: candies = [12,1,12], extraCandies = 10
     * Output: [true,false,true]
     */

    private int findMaxCandies(int[] candies){
        int maxCandies=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>maxCandies){
                maxCandies=candies[i];
            }
        }
        return maxCandies;
    }

    private List<Boolean> kidsWithCandies( int[] candies, int extraCandies){
        int max=findMaxCandies(candies);
        List<Boolean> result=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                result.add(i,true);
            }
            else{
                result.add(i,false);
            }
        }
        return result;
    }

    public static void main(String...k) {
        int[] candies={2,3,5,1,3};
        List<Boolean> result=new ArrayList<>();
        Blind2 blind2=new Blind2();
        result=blind2.kidsWithCandies(candies,3);
        System.out.println(result);
    }

}

