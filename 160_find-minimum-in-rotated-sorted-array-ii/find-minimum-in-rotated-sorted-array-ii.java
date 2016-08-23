/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-08-15 03:56
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // if (num == null || num.length == 0) return -1;
        // int min = Integer.MAX_VALUE;
        // for (int i : num) {
        //     min = i < min ? i : min;
        // }
        // return min;
        
        if (num == null || num.length == 0) return -1;
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == num[end]) {
                end--;
            }
            else if (num[mid] < num[end]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return num[start] > num[end] ? num[end] : num[start];
    }
}