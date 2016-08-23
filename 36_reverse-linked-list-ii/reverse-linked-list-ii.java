/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/reverse-linked-list-ii
@Language: Java
@Datetime: 16-07-11 10:23
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode pre_start = head;
        ListNode start = pre_start.next;
        ListNode move = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = move.next;
            move.next = pre_start.next;
            pre_start.next = move;
            move = start.next;
        }
        return dummy.next;
    }
}