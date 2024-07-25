package Interview150LeetCode;

public class BestTimeBuySellStock {

    /*
    Input: prices = [7,1,5,3,6,4]

    []
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

     */


    public static int maxProfit(int[] prices) {
        int buy = prices[0], max_profit = 0;
        for (int i = 1; i < prices.length; i++) {

            // Checking for lower buy value
            if (buy > prices[i])
                buy = prices[i];

                // Checking for higher profit
            else if (prices[i] - buy > max_profit)
                max_profit = prices[i] - buy;
        }
        return max_profit;
    }

    public static void main(String...k){
        int[] num={7,1,5,3,6,4};
        System.out.println(maxProfit(num));
    }
}
