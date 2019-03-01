package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = solution(head);
        System.out.println(head);
    }

    public static ListNode solution(ListNode head) {
        ListNode current = head;
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        head = preNode;
        while (current != null && current.next != null) {
            ListNode temp = current.next;

            current.next = temp.next;
            temp.next = current;
            preNode.next = temp;

            preNode = current;
            current = current.next;
        }

        return head.next;
    }

}
