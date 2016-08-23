/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 16-06-13 12:51
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) return new int[]{-1, -1};
        int firstTargetIndex = searchFirstTarget(A, target);
        int lastTargetIndex = searchLastTarget(A, target);
        return new int[]{firstTargetIndex, lastTargetIndex};
    }
    public int searchFirstTarget(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while (low + 1 < high) {
            mid = (low + high) / 2;
            if (target > A[mid]) low = mid + 1;
            else high = mid;
        }
        if (target == A[high] && target == A[low]) return low;
        else if (target == A[low]) return low;
        else if (target == A[high]) return high;
        else return -1;
    }
    
    public int searchLastTarget(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while (low + 1 < high) {
            mid = (low + high) / 2;
            if (target < A[mid]) high = mid - 1;
            else low = mid;
        }
        if (target == A[high] && target == A[low]) return high;
        else if (target == A[high]) return high;
        else if (target == A[low]) return low;
        else return -1;
    }
}
