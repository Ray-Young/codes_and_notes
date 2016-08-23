/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 16-08-03 09:54
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null  
            || prices.length == 0  
            || prices.length == 1) {
                return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int profit = 0;
        
        // Record the max profit before i (including i); till i, the stock must be sold already.
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        // Record the max profit from [length, 0]
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i --) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
};