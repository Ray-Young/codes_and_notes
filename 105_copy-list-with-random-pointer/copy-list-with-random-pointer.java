/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 16-07-14 07:37
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        RandomListNode dummy= new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode;
        
        HashMap <RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            }
            else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;
            
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                }
                else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            
            pre = newNode;
            head = head.next;
        }
        return dummy.next;
    }
}