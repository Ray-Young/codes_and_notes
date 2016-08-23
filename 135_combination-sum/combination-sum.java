/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 16-08-01 03:10
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return results;
        
        List<Integer> solution = new ArrayList<>();
        //输出结果必须是sorted，因此在这里直接对candidates进行sort
        Arrays.sort(candidates);
        helper(results, solution, candidates, target, 0);
        
        return results;
    }
    
    private void helper(
        List<List<Integer>> results,
        List<Integer> solution,
        int[] candidates,
        int target,
        int start) {
            
        if (sum(solution) == target) {
            results.add(new ArrayList<>(solution));
            return;
        }
        
        int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            //剪枝，因为传入的candidates已经是sorted，因此如果结果大于target，之后的分支就不用再进行了
            if (sum(solution) + candidates[i] > target) {
                break;
            }
            
            if (prev != -1 && prev == candidates[i]) {
                continue;
            }
            solution.add(candidates[i]);
            helper(results, solution, candidates, target, i);
            solution.remove(solution.size() - 1);
            
            prev = candidates[i];
        }
    }
    
    private int sum(List<Integer> solution) {
        int result = 0;
        for (int i : solution) {
            result = result + i;
        }
        return result;
    }
}