/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Java
@Datetime: 16-06-25 12:11
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
    ArrayList<TreeNode> list = new ArrayList<>();
    int index = -1;
    int length;
    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
        this.length = list.size();
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        int count = index + 1;
        if (count <= length - 1) return true;
        else return false;
    }
    
    //@return: return next node
    public TreeNode next() {
        index++;
        return list.get(index);
    }
    
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }
}