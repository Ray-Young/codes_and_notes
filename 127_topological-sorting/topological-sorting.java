/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 16-07-25 03:07
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        
        ArrayList<DirectedGraphNode> ret = new ArrayList<>();
        Queue<DirectedGraphNode> q = new LinkedList<>();
        HashMap <DirectedGraphNode, Integer> map = new HashMap<>();
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) map.put(neighbor, map.get(neighbor) + 1);
                else map.put(neighbor, 1);
            }
        }
        
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                ret.add(node);
            }
        }
        
        while (!q.isEmpty()) {
            DirectedGraphNode head = q.poll();
            for (DirectedGraphNode neighbor : head.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    q.offer(neighbor);
                    ret.add(neighbor);
                }
            }
        }
        
        return ret;
    }
}