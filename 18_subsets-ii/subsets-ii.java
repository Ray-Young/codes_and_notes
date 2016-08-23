/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 16-08-12 03:43
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
     
    // Recursive Version
    // public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
    //     ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    //     if (S == null || S.size() == 0) return results;
        
    //     ArrayList<Integer> solution = new ArrayList<>();
    //     Collections.sort(S);
    //     helper(results, solution, S, 0);
    //     return results;
    // }
    
    // public void helper(
    //     ArrayList<ArrayList<Integer>> results,
    //     ArrayList<Integer> solution,
    //     ArrayList<Integer> S,
    //     int index) {
    //     // 这里的add一定要new，ArrayList是change by reference，如果不new就会导致每次修改的solution都是针对同一个在修改。
    //     results.add(new ArrayList<>(solution));
    //     for (int i = index; i < S.size(); i++) {
    //         solution.add(S.get(i));
    //         if (results.contains(solution)) {
    //             solution.remove(solution.size() - 1);
    //             continue;
    //         }
    //         helper(results, solution, S, i + 1);
    //         solution.remove(solution.size() - 1);
    //     }
    // }
    
    // Iterative Version
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (S == null || S.size() == 0) return results;
        
        results.add(new ArrayList<Integer>());
        Collections.sort(S);
        for (int i : S) {
            int k = results.size();
            for (int j = 0; j < k; j++) {
                ArrayList<Integer> solution = new ArrayList<>(results.get(j));
                solution.add(i);
                if (results.contains(solution)) {
                    continue;
                }
                results.add(solution);
            }
        }
        return results;
    }
}
