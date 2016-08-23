/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 16-08-10 03:47
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        //非递归法
        // ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
        // if (nums == null || nums.size() == 0) return rets;
        
        // //ArrayList<Integer> head = new ArrayList<>(nums.get(0)); 其结果是空。因为nums.get(0)不是一个ArrayList，它只是一个int，直接初始化只接受同类型，即ArrayList必须对接ArrayList，而不是一个数字
        // ArrayList<Integer> head = new ArrayList<>();
        // head.add(nums.get(0));
        // rets.add(head);
        // //rets.add(new ArrayList<Integer>(nums.get(0)));
        // for (int i = 1; i < nums.size(); i++) {
        //     ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        //     for (ArrayList<Integer> array : rets) {
        //         for (int j = 0; j <= array.size(); j++) {
        //             ArrayList<Integer> set = new ArrayList<>(array);
        //             set.add(j, nums.get(i));
        //             tmp.add(set);
        //         }
        //     }
        //     rets = tmp;
        // }
        // return rets;
        
        //递归法 DFS
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null || nums.size() == 0) return results;
        ArrayList<Integer> solution = new ArrayList<>();
        
        helper(results, solution, nums);
        return results;
    }
    
    public void helper(
        ArrayList<ArrayList<Integer>> results, 
        ArrayList<Integer> solution,
        ArrayList<Integer> nums) {
            if (solution.size() == nums.size()) {
                results.add(new ArrayList<Integer>(solution));
            }
            for (int i = 0; i < nums.size(); i++) {
                if (solution.contains(nums.get(i))) {
                    continue;
                }
                solution.add(nums.get(i));
                helper(results, solution, nums);
                solution.remove(solution.size() - 1);
            }
    }
}
