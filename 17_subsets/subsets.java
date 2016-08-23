/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 16-08-11 07:11
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    // Recursive Version
    // public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    //     ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    //     if (nums == null || nums.length == 0) return results;
    //     ArrayList<Integer> solution = new ArrayList<>();
    //     Arrays.sort(nums);
    //     helper(results, solution, nums, 0);
    //     return results;
    // }
    
    // public void helper(
    //     ArrayList<ArrayList<Integer>> results,
    //     ArrayList<Integer> solution,
    //     int[] nums,
    //     int index) {
        
    //     // 递归也可以没有return。视情况而变化。return其实是递归中的break，而没有return则意味着将其执行到底。
    //     results.add(new ArrayList<Integer>(solution));
    //     for (int i = index; i < nums.length; i++) {
    //         solution.add(nums[i]);
    //         helper(results, solution, nums, i + 1);
    //         solution.remove(solution.size() - 1);
    //     }
    // }
    
    
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        results.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        
        for (int i : nums) {
            int k = results.size();
            for (int j = 0; j < k; j++) {
                ArrayList<Integer> tmp = new ArrayList<>(results.get(j));
                tmp.add(i);
                results.add(tmp);
            }
        }
        return results;
    }
}