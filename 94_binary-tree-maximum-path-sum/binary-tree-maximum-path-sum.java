/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 16-06-23 04:16
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    public int maxPathDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        maxValue = Math.max(maxValue, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}