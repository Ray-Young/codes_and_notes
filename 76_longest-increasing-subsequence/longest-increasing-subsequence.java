/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 16-06-30 12:50
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int dp[] = new int[nums.length];
        int max = 0;
        if (nums == null) return -1;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        for (int i = 0; i < nums.length; i++) dp[i] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    if (dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
