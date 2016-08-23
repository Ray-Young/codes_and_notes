/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Java
@Datetime: 16-08-03 08:44
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int diff = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            diff = prices [i+1] - prices[i];
            if (diff > 0) {
                profit = profit + diff;
            }
        }
        return profit;
    }
};