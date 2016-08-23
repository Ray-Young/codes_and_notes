/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 16-08-11 05:50
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */

    // Recursive Version
    // public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
    //     ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    //     if (nums == null | nums.size() == 0) return results;
    //     ArrayList<Integer> solution = new ArrayList<>();
    //     boolean[] visited = new boolean[nums.size()];
    //     Collections.sort(nums);
    //     helper(results, solution, nums, visited);
    //     return results;
    // }
    
    // public void helper(
    //     ArrayList<ArrayList<Integer>> results,
    //     ArrayList<Integer> solution,
    //     ArrayList<Integer> nums,
    //     boolean[] visited) {
    //     if (solution.size() == nums.size()) {
    //         //去重，效率上不如剪枝来的快捷，但是这个容易想。
    //         //if (!results.contains(solution)) {
    //             results.add(new ArrayList<Integer>(solution));
    //             return;
    //         //}
    //     }
        
    //     for (int i = 0; i < nums.size(); i++) {
    //         // 一步重要的剪枝。如果前后两元素相同，而当前元素的之前序列没有被访问过，说明这个组合在之前已经出现过了。
    //         if (visited[i] || (i != 0 && nums.get(i) == nums.get(i-1) && !visited[i-1])) {
    //             continue;
    //         }
    //         solution.add(nums.get(i));
    //         visited[i] = true;
    //         helper(results, solution, nums, visited);
    //         visited[i] = false;
    //         solution.remove(solution.size() - 1);
    //     }
    // }
    
    // Non Recursive Version
    
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null || nums.size() == 0) return results;
        ArrayList<Integer> head = new ArrayList<Integer>();
        head.add(nums.get(0));
        results.add(head);
        
        for (int i = 1; i < nums.size(); i++) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (ArrayList<Integer> solution : results) {
                int k = solution.size();
                for (int j = 0; j <= k; j++) {
                    ArrayList<Integer> tmp = new ArrayList<>(solution);
                    tmp.add(j, nums.get(i));
                    if (list.contains(tmp)) {
                        continue;
                    }
                    list.add(tmp);
                }
            }
            results = list;
        }
        return results;
    }
}
