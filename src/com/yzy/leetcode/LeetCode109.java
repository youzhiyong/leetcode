package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:


 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode109 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
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



        return head;
    }


}
