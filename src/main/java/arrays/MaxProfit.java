package arrays;

/**
 * Created by gadzik on 07.07.20.
 */
public class MaxProfit {
    // https://algorithms.tutorialhorizon.com/stock-single-sell-problem-on-solution/
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            else if (maxprofit < prices[i] - minprice) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int arr[] = { 14, 12, 70, 15, 99, 65, 21, 90 };
        System.out.println("Maximum profit :" + maxProfit(arr));
    }
}
