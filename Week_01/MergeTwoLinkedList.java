/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode tmpTail = new ListNode(1);
        ListNode start = tmpTail;
        while (null != l1 || null != l2) {
            if (l1 == null) {
                tmpTail.next = l2;
                return start.next;
            }
            if (l2 == null) {
                tmpTail.next = l1;
                return start.next;
            }

            if (l1.val <= l2.val) {
                tmpTail.next = l1;
                l1 = l1.next;
                tmpTail = tmpTail.next;
            } else {
                tmpTail.next = l2;
                l2 = l2.next;
                tmpTail = tmpTail.next;
            }
        }
        return start.next;
    }
}
// @lc code=end

