/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Java
@Datetime: 16-06-23 10:38
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        ArrayList<Integer> currentArray = new ArrayList<>();
        
        currentLevel.offer(root);
        while(!currentLevel.isEmpty()) {
            for (TreeNode node : currentLevel) {
                currentArray.add(node.val);
                if (node.left != null) nextLevel.offer(node.left);
                if (node.right != null) nextLevel.offer(node.right);
            }
            ret.add(currentArray);
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            currentArray = new ArrayList<>();
        }
        return ret;
    }
}