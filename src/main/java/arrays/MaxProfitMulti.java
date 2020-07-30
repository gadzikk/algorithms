package arrays;

/**
 * Created by gadzik on 07.07.20.
 */
public class MaxProfitMulti {
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }

            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }

            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] price = { 7,1,5,3,6,4 };

        System.out.print("\nTotal profit earned is " + maxProfit(price));
    }
}
