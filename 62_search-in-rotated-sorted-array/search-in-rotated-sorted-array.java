/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 16-06-13 11:55
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        int min = findMin(A);
        if (target == A[min]) return min;
        else {
            int low = target > A[A.length - 1] ? 0 : min;
            int high = target > A[A.length -1] ? min - 1 : A.length - 1;
            int mid = 0;
            while (low + 1 < high) {
                mid = (low + high) / 2;
                if (target > A[mid]) low = mid + 1;
                else high = mid;
            }
            if (A[high] == target) return high;
            else if (A[low] == target) return low;
            else return -1;
        }
    }
    
    public int findMin(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while (low + 1 < high) {
            mid = (low + high) / 2;
            if (A[high] > A[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return A[high] > A[low] ? low : high;
    }
}
