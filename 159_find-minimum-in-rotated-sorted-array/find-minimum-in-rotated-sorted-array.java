/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 16-08-12 10:34
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return -1;
        int low = 0;
        int high = num.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < num[high]) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        return num[low] < num[high] ? num[low] : num[high];
    }
}