/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 16-06-11 11:12
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (target < nums[mid]) {
                high = mid -1;
                mid = (low + high) / 2;
            }
            else if (target > nums[mid]) {
                low = mid + 1;
                mid = (low + high) / 2;
            }
            else {
                if (mid == 0) return mid;
                else if (target == nums[mid - 1]) {
                    high = mid - 1;
                    mid = (low +high) / 2;
                }
                else return mid;
            }
        }
        return -1;
    }
}