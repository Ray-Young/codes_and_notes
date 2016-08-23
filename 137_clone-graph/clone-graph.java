/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 16-07-24 09:29
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
     
     //利用BFS遍历图（本题使用何种Queue和Stack都可以，但是为了专业化，用queue），概念是BFS，因为每次都获取节点的全部neighbors，然后再访问下一个节点。其概念是BFS。遍历之后是普通的deep copy问题
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        nodes = BFSTraversal(node);
        
        // make a old->new UndirectedGraphNode HashMap
        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        
        // copy nodes
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode new_node = map.get(n);
            // copy neighbors
            for (UndirectedGraphNode neighbor: n.neighbors) {
                new_node.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    
    // BFS Traversal Graph
    public ArrayList<UndirectedGraphNode> BFSTraversal(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        q.offer(node);
        set.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode head = q.poll();
            for (UndirectedGraphNode n : head.neighbors) {
                if (!set.contains(n)) {
                    set.add(n);
                    q.offer(n);
                } 
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}