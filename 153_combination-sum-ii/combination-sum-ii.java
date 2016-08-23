/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 16-08-01 03:43
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) return results;
        List<Integer> solution = new ArrayList<>();
        
        Arrays.sort(num);
        helper(results, solution, num, target, 0);
        return results;
    }
    
    public void helper(
        List<List<Integer>> results,
        List<Integer> solution,
        int[] num,
        int target,
        int index) {
        if (sum(solution) == target) {
            results.add(new ArrayList<Integer>(solution));
            return;
        }
        int prev = -1;
        for (int i = index; i < num.length; i++) {
            if (sum(solution) + num[i] > target) {
                break;
            }
            
            if (prev != -1 && prev == num[i]) {
                continue;
            }
            
            solution.add(num[i]);
            helper(results, solution, num, target, i+1);
            solution.remove(solution.size() - 1);
            prev = num[i];
        }
    }
    
    public int sum(List<Integer> solution) {
        int result = 0;
        for (int i : solution) {
            result = result + i;
        }
        return result;
    }
}