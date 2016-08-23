/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/binary-tree-preorder-traversal
@Language: Java
@Datetime: 16-06-23 03:10
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
     * @return: Preorder in ArrayList which contains node values.
     */
     ArrayList<Integer> ret = new ArrayList<Integer>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            ret.add(root.val);
        
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return ret;
    }
}