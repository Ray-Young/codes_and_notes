/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 16-08-02 08:39
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int index = A.length + B.length;
        if (index == 0) return new int[0];
        int m = A.length;
        int n = B.length;
        int[] result = new int[index];
        while (m > 0 && n > 0) {
            if (A[m - 1] < B[n - 1]) {
                result[--index] = B[--n];
            }
            else {
                result[--index] = A[--m];
            }
        }
        while (m > 0) {
            result[--index] = A[--m];
        }
        while (n > 0) {
            result[--index] = B[--n];
        }
        return result;
    }
}