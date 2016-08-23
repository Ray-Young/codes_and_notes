/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 16-07-31 07:39
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) return null;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        
        helper(results, solution, n, k, 1);
        return results;
    }
    
    public void helper(
        List<List<Integer>> results,
        List<Integer> solution,
        int n,
        int k,
        int start) {
            if (solution.size() == k) {
                results.add(new ArrayList<Integer>(solution));
            }
            
            for (int i = start; i <= n; i++) {
                solution.add(i);
                helper(results, solution, n, k, i+1);
                solution.remove(solution.size() - 1);
            }
    }
}