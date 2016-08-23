/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 16-06-30 02:40
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        if (A.length == 1) return true;
        if (A[0] == 0) return false;
        for (int i = 1; i < A.length - 1; i++) {
            A[i] = Math.max(A[i], A[i-1] - 1);
            if (A[i] == 0) return false;
        }
        if (A[A.length - 2] > 0) return true;
        else return false;
    }
}
