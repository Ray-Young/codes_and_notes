/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 16-08-06 03:41
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}