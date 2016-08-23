/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Java
@Datetime: 16-06-26 11:24
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean flag = false;
    TreeNode node;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        if (inorderSuccessor(root.left, p) != null) return node;
        if (flag) {
            node = root;
            return node;
        }
        if (root == p) flag = true;
        if (inorderSuccessor(root.right, p) != null) return node;
        
        return null;
    }
}