/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/distinct-subsequences
@Language: Java
@Datetime: 16-07-03 08:06
*/

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        int m = T.length();
        int n = S.length();
        if (n == 0) return 0;
        if (m == 0) return 1;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) dp[i][0] = 0;
        for (int i = 1; i <= n; i++) dp[0][i] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (T.charAt(i-1) != S.charAt(j-1)) dp[i][j] = dp[i][j-1];
                else dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}