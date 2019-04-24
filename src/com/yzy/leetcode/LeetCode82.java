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
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        head = solution2(head);
        System.out.println(head);
    }

    public static ListNode solution(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode p = node;
        while (p.next != null) {
            int val = p.next.val;
            ListNode end = p.next;
            if (end.next != null && end.next.val == val) {
                do {
                    end = end.next;
                } while (end.next != null && end.next.val == val);
                p.next = end.next;
            } else {
                p = p.next;
            }
        }
        return node.next;
    }

    //更改题目要求：要求保留一个重复的元素
    public static ListNode solution2(ListNode head) {
        ListNode p = head;
        while (p != null) {
            int val = p.val;
            ListNode end = p.next;
            if (end != null && end.val == val) {
                do {
                    end = end.next;
                } while (end != null && end.val == val);
                p.next = end;
            } else {
                p = p.next;
            }
        }
        return head;
    }

}
