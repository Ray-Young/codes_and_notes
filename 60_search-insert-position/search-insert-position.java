/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Java
@Datetime: 16-06-11 05:40
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid = (low + high)/2;
        while (low <= high) {
            if (target < A[mid]) {
                high = mid - 1;
                mid = (low + high)/2;
            }
            else if (target > A[mid]) {
                low = mid + 1;
                mid = (low + high)/2;
            }
            else return mid;
        }
        if (high < 0) return 0;
        if (low == A.length) return A.length;
        return mid + 1;
    }
}
