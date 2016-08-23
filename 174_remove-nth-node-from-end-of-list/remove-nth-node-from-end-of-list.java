/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 16-07-08 05:34
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        stack.push(dummy);
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode curr = stack.peek();
        ListNode prev = null;
        int pos = 0;
        while (pos != n) {
            curr = stack.pop();
            prev = stack.peek();
            pos++;
        }
        prev.next = curr.next;
        return dummy.next;
    }
}
