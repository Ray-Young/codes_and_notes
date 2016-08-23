/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 16-06-29 12:08
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int step_before_one = 2;
        int step_before_two = 1;
        int all_steps = 0;
        for (int i = 2; i < n; i++) {
            all_steps = step_before_one + step_before_two;
            step_before_two = step_before_one;
            step_before_one = all_steps;
        }
        return all_steps;
    }
}