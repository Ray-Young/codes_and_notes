/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/longest-common-subsequence
@Language: Java
@Datetime: 16-07-03 10:09
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null) return 0;
        int m = B.length();
        int n = A.length();
        
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) dp[0][i] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (B.charAt(i-1) == A.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
