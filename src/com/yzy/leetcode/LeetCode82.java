package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

 示例 1:

 输入: 1->2->3->3->4->4->5
 输出: 1->2->5
 示例 2:

 输入: 1->1->1->2->3
 输出: 2->3
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode82 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = solution(head);
        System.out.println(head);
    }

    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode p = node;
        while (p.next != null) {
            int val = p.next.val;
            ListNode end = p.next;
            if (end.next != null && end.next.val == val) {
                while (end.next != null && end.next.val == val) {
                    end = end.next;
                }
                p.next = end.next;
            } else {
                p = p.next;
            }
        }
        return node.next;
    }

}
