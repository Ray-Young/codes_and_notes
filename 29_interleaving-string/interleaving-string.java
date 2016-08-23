/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/interleaving-string
@Language: Java
@Datetime: 16-07-03 14:17
*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s2.length();
        int n = s1.length();
        int k = s3.length();
        if (m + n != k) return false;
        
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        boolean[][] dp = new boolean[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int l = i + j - 1;
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) {
                    if (str1[j-1] == str3[j-1]) dp[0][j] = dp[0][j-1];
                }
                else if (j == 0) {
                    if (str2[i-1] == str3[i-1]) dp[i][0] = dp[i-1][0];
                }
                else {
                    dp[i][j] = (str2[i-1] == str3[l] ? dp[i-1][j] : false) || (str1[j-1] == str3[l] ? dp[i][j-1] : false);
                }
            }
        }
        return dp[m][n];
    }
}