package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。

 示例:

 输入: head = 1->4->3->2->5->2, x = 3
 输出: 1->2->2->4->3->5
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode86 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        head = solution2(head, 3);
        System.out.println(head);
    }

    public static ListNode solution(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode p = node;
        ListNode midNode = null;
        while (p.next != null) {
            int val = p.next.val;
            if (val >= x && midNode == null) {
                midNode = p.next;
                head = p;
            } else if (val < x && midNode != null){
                ListNode temp = p.next;
                p.next = temp.next;
                head.next = temp;
                temp.next = midNode;

                head = head.next;
                continue;
            }
            p = p.next;
        }
        return node.next;
    }

    public static ListNode solution2(ListNode head, int x) {
        ListNode node1 = new ListNode(-1); //左边的node
        ListNode node2 = new ListNode(-1); //右边的node
        ListNode p1 = node1; // 指向node1最后的元素
        ListNode p2 = node2; // 指向node2最后的元素

        while (head != null) {
            if (head.val >= x) {
                p2.next = head;
                p2 = p2.next;
                head = head.next;
                p2.next = null;
            } else {
                p1.next = head;
                p1 = p1.next;
                head = head.next;
            }
        }
        p1.next = node2.next;
        return node1.next;
    }



}
