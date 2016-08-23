/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/edit-distance
@Language: Java
@Datetime: 16-07-02 05:48
*/

public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() != 0) return word2.length();
        if (word2.length() == 0 && word1.length() != 0) return word1.length();
        if (word1.length() == 0 && word2.length() == 0) return 0;
        
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        for (int i = 0; i <= w2.length; i++) dp[i][0] = i;
        for (int i = 0; i <= w1.length; i++) dp[0][i] = i;
        
        for (int i = 1; i <= w2.length; i++) {
            for (int j = 1; j <= w1.length; j++) {
                if (w2[i-1] == w1[j-1]) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }
        return dp[w2.length][w1.length];
    }
}