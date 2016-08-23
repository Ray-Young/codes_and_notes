/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock
@Language: Java
@Datetime: 16-08-03 08:55
*/

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    // public int maxProfit(int[] prices) {
    //     
    //     int maxProfit = 0;
    //     for (int i = 0; i < prices.length; i++) {
    //         maxProfit = Math.max(maxProfit, getMax(i, prices));
    //     }
    //     return maxProfit;
    // }
    
    // public int getMax(int index, int[] prices) {
    //     int max = 0;
    //     for (int i = index; i < prices.length; i++) {
    //         max = Math.max(max, prices[i]);
    //     }
    //     return max - prices[index];
    // }
    
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i : prices) {
            min = Math.min(min, i);
            profit = Math.max(profit, i - min);
        }
        return profit;
    }
}