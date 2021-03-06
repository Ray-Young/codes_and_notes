/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/two-sum
@Language: Java
@Datetime: 16-08-07 04:34
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
                //return result;
            }
            map.put(target - numbers[i], i);
        }
        return new int[2];
    }
}