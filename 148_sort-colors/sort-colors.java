/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Java
@Datetime: 16-08-09 03:46
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = nums.length;
        int left = 0;
        int right = l - 1;
        int i = 0;
        // i <= right That's the trick point.
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            }
            else if (nums[i] == 1) {
                i++;
            }
            else {
                swap(nums, right, i);
                right--;
            }
        }
    }
    
    public void swap(int[] nums, int j, int i) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}