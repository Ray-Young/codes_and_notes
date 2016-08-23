/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Java
@Datetime: 16-06-23 06:14
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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathSum2(root.left));
        int right = Math.max(0, maxPathSum2(root.right));
        return Math.max(left, right) + root.val;
    }
}