/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 16-07-08 07:13
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        boolean isfind = false;
        ListNode start = dummy;
        ListNode after_start = head;
        while (after_start != null) {
            if (start.val < x && after_start.val >= x) {
                isfind = true;
                break;
            }
            start = after_start;
            after_start = start.next; 
        }
        if (!isfind) return dummy.next;
        ListNode move = after_start.next;
        while (move != null) {
            if (move.val < x) {
                after_start.next = move.next;
                move.next = start.next;
                start.next = move;
                start = move;
                move = after_start.next;
            }
            else {
                after_start = after_start.next;
                move = move.next;
            }
        }
        return dummy.next;
    }
}
