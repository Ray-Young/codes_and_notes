/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 16-08-15 09:59
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = findRow(matrix, target);
        int l = matrix[0].length - 1;
        int start = 0;
        int end = l;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (matrix[row][start] == target || matrix[row][end] == target) { 
            return true;
        }
        else {
            return false;
        }
    }
    
    public int findRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return matrix[end][0] > target ? start : end;
    }
}
