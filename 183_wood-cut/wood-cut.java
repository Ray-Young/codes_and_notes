/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 16-08-22 04:33
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(L[i], max);
        }
        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) < k) {
                end = mid;
            }
            else start = mid;
        }
        
        if (count(L, end) >= k) return end;
        else if (count(L, start) >= k) return start;
        else return 0;
    }
    
    public int count(int[] L, int length) {
        int sum = 0;
        for (int i : L) {
            sum = sum + i/length;
        }
        return sum;
    }
}