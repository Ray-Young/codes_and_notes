/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list
@Language: Java
@Datetime: 16-08-09 07:18
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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (head.val == head.next.val) {
                //ListNode tmp = head;
                while (head.next != null && head.val == head.next.val) {
                    head.next = head.next.next;
                }
                //tmp.next = head;
            }
            else {
                head = head.next;
            }
        }
        return dummy.next;
    }  
}