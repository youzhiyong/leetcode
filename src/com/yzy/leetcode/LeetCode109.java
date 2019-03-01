package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定的有序链表： [-10, -3, 0, 5, 9],

 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

        0
      /  \
    -3    9
   /     /
 -10   5

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
