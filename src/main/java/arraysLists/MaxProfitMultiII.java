package arraysLists;

/**
 * Created by gadzik on 07.07.20.
 */
public class MaxProfitMultiII {
 // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] price = { 7,1,5,3,6,4 };

        System.out.print("\nTotal profit earned is " + maxProfit(price));
    }
}
