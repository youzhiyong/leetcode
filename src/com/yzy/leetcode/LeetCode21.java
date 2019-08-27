package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode21 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        //node2.next = node3;
        node2.next = node4;

        ListNode head1 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(4);
        head1.next = node13;
        //node12.next = node13;
        node13.next = node14;
        head = solution(head, head1);
        System.out.println(head);
    }

    public static ListNode solution(ListNode l1,ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {  //有一个链表为空，则退出循环
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
            current.next = null;
        }

        //将不为空的链表添加到尾部
        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return head.next;
    }

}
