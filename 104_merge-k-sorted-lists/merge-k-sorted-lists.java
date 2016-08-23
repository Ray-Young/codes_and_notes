/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Java
@Datetime: 16-07-15 03:01
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);
        
        while (lists.size() > 1) {
            List<ListNode> new_lists = new LinkedList<>();
            for (int i = 0; i+1 < lists.size(); i+=2) {
                new_lists.add(mergeTwoLists(lists.get(i), lists.get(i+1)));
            }
            if (lists.size() % 2 == 1) {
                new_lists.add(lists.get(lists.size() - 1));
            }
            lists = new_lists;
        }
        return lists.get(0);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }
            else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        if (l1 != null) head.next = l1;
        else head.next = l2;
        return dummy.next;
    }
}
