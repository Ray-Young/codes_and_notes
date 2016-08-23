/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 16-06-29 12:43
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        int m = triangle.length;
        for (int i = 0; i < m; i++) {
            int n = triangle[i].length;
            for (int j = 0; j < n; j++) {
                if (j == 0 && i != 0) triangle[i][j] = triangle[i-1][j] + triangle[i][j];
                else if (j == n-1 && i != 0) triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                else if (j == 0 && i == 0) triangle[i][j] = triangle[i][j];
                else triangle[i][j] = Math.min(triangle[i-1][j], triangle[i-1][j-1]) + triangle[i][j];
            }
        }
        Arrays.sort(triangle[m-1]);
        return triangle[m-1][0];
    }
}
