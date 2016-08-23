/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/reorder-list
@Language: Java
@Datetime: 16-07-12 09:53
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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        if (head == null || head.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode prev = null;
        ListNode curr = p1.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode move = prev;
        p1.next = move;
        while (head != p1) {
            p1.next = move.next;
            move.next = head.next;
            head.next = move;
            head = move.next;
            move = p1.next;
        }
    }
}
