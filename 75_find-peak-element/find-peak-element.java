/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 16-08-21 17:58
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid + 1]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return A[start] > A[end] ? start : end;
    }
}
