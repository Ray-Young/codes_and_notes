/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Java
@Datetime: 16-06-16 11:42
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
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        
        return Math.max(left, right) + 1;
    }
}