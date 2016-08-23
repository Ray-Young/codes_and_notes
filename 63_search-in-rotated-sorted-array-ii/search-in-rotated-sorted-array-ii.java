/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-08-15 04:13
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) return false;
        // Solution One
        
        // for (int i : A) {
        //     if (i == target) {
        //         return true;
        //     }
        // }
        // return false;
        
        // Solution Two
        int minIndex = findMinIndex(A);
        int l = A.length - 1;
        int start = A[l] >= target ? minIndex : 0;
        int end = A[l] >= target ? l : minIndex - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (A[start] == target || A[end] == target) return true;
        else return false;
    }
    
    public int findMinIndex(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == A[end]) {
                end--;
            }
            else if (A[mid] < A[end]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return A[start] < A[end] ? start : end;
    }
}
