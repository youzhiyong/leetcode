package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:

 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = solution(head);
        System.out.println(head);
    }

    public static ListNode solution(ListNode head) {
        if (head == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

}
