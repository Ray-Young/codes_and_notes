/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 16-06-30 10:17
*/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null) return -1;
        if (A[0] == 0) return -1;
        if (A.length == 1) return 1;
        int edge = A[0];
        int maxreach = A[0];
        int minstep = 0;
        
        for (int i = 1; i < A.length; i++) {
            if (i > edge) {
                edge = maxreach;
                minstep++;
            }
            maxreach = Math.max(maxreach, A[i] + i);
            if (edge >= A.length - 1)
            return ++minstep;
        }
        return 0;
    }
}
